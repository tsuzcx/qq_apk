package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageInfo
  extends UploadEditItemInfo
{
  public String a;
  protected String b;
  public String c;
  public URL d;
  public String e;
  public int f;
  public int j;
  public int k;
  public int l;
  public ConcurrentHashMap<String, TroopHomeworkHelper.UploadFileTask> m;
  public long n;
  
  public ImageInfo() {}
  
  public ImageInfo(String paramString)
  {
    a(paramString);
    f();
    this.e = String.valueOf(hashCode());
  }
  
  public ImageInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    this.e = String.valueOf(hashCode());
  }
  
  public static String h()
  {
    Object localObject = new VFSFile(TroopHWJsPlugin.a);
    if (!((VFSFile)localObject).exists())
    {
      ((VFSFile)localObject).mkdirs();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TroopHWJsPlugin.a);
      ((StringBuilder)localObject).append(".nomedia");
      FileUtils.createFileIfNotExits(((StringBuilder)localObject).toString());
    }
    return TroopHWJsPlugin.a;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Stream<ImageInfo> a(XMediaEditor paramXMediaEditor)
  {
    this.o = 1;
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("ImageInfo", 2));
    Object localObject1 = localObject2;
    if (!FileUtils.fileExistsAndNotEmpty(this.c)) {
      localObject1 = ((Stream)localObject2).map(new ImageInfo.CompressImageSegment(this.k));
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty(this.b)) {
      localObject2 = ((Stream)localObject1).map(new ImageInfo.UploadMediaSegment(0, paramXMediaEditor, paramXMediaEditor.a("troopuin")));
    }
    localObject1 = paramXMediaEditor.findViewHolderForLayoutPosition(this.g);
    if ((localObject1 instanceof ImageItem.ImageViewHolder))
    {
      localObject1 = (ImageItem.ImageViewHolder)localObject1;
      if (this.e.equals(((ImageItem.ImageViewHolder)localObject1).g.getTag())) {
        ((ImageItem)((XMediaEditorAdapter)paramXMediaEditor.getAdapter()).a.a(1)).a((ImageItem.ImageViewHolder)localObject1, this, 0);
      }
    }
    return ((Stream)localObject2).map(new UIThreadOffFunction(null));
  }
  
  public TroopHomeworkHelper.UploadFileTask a(String paramString1, String paramString2)
  {
    if (this.m == null) {
      this.m = new ConcurrentHashMap();
    }
    if (!this.m.containsKey(paramString1))
    {
      paramString2 = new TroopHomeworkHelper.UploadFileTask(MobileQQ.sMobileQQ.waitAppRuntime(null), paramString1, paramString2);
      this.m.put(paramString1, paramString2);
      return paramString2;
    }
    return (TroopHomeworkHelper.UploadFileTask)this.m.get(paramString1);
  }
  
  public void a(String paramString)
  {
    try
    {
      this.d = new File(paramString).toURI().toURL();
      this.a = paramString;
      return;
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    QLog.e("ImageInfo", 1, "setURLFromPath exception.");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageInfo", 2, new Object[] { "ImageInfo createFrom json: ", paramJSONObject });
    }
    this.h = paramJSONObject;
    b(paramJSONObject.optString("url"));
    this.f = paramJSONObject.optInt("width");
    this.j = paramJSONObject.optInt("height");
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b(String paramString)
  {
    try
    {
      this.d = new URL(paramString);
      this.b = paramString;
      return;
    }
    catch (Exception paramString)
    {
      label18:
      break label18;
    }
    QLog.e("ImageInfo", 1, "Image setURLFromContentUrl exception.");
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "img");
      localJSONObject.put("url", this.b);
      localJSONObject.put("width", this.f);
      localJSONObject.put("height", this.j);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      label56:
      break label56;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ImageInfo", 2, "ImageInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.a)) {
      return this.b;
    }
    return this.a;
  }
  
  public void f()
  {
    long l1 = System.currentTimeMillis();
    if (FileUtils.fileExistsAndNotEmpty(this.a))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(this.a, localOptions);
      this.f = localOptions.outWidth;
      this.j = localOptions.outHeight;
      int i = JpegExifReader.readOrientation(this.a);
      if ((i == 6) || (i == 5) || (i == 8) || (i == 7))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize need orientation. before width=", Integer.valueOf(this.f), ", height=", Integer.valueOf(this.j), ", path=", this.a });
        }
        i = this.f;
        this.f = this.j;
        this.j = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize result. width=", Integer.valueOf(this.f), ", height=", Integer.valueOf(this.j), ", path=", this.a, ", cost=", Long.valueOf(System.currentTimeMillis() - l1) });
      }
    }
  }
  
  public boolean g()
  {
    return TextUtils.isEmpty(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
 * JD-Core Version:    0.7.0.1
 */