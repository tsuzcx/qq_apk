package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
import org.json.JSONException;
import org.json.JSONObject;

public class ImageInfo
  extends UploadEditItemInfo
{
  public int a;
  public long a;
  public String a;
  public URL a;
  public ConcurrentHashMap<String, TroopHomeworkHelper.UploadFileTask> a;
  public int b;
  protected String b;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public ImageInfo() {}
  
  public ImageInfo(String paramString)
  {
    b(paramString);
    a();
    this.jdField_d_of_type_JavaLangString = String.valueOf(hashCode());
  }
  
  public ImageInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    this.jdField_d_of_type_JavaLangString = String.valueOf(hashCode());
  }
  
  public static String b()
  {
    VFSFile localVFSFile = new VFSFile(TroopHWJsPlugin.jdField_a_of_type_JavaLangString);
    if (!localVFSFile.exists())
    {
      localVFSFile.mkdirs();
      FileUtils.c(TroopHWJsPlugin.jdField_a_of_type_JavaLangString + ".nomedia");
    }
    return TroopHWJsPlugin.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Stream<ImageInfo> a(XMediaEditor paramXMediaEditor)
  {
    this.g = 1;
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("ImageInfo", 2));
    Object localObject1 = localObject2;
    if (!FileUtil.b(this.jdField_c_of_type_JavaLangString)) {
      localObject1 = ((Stream)localObject2).map(new ImageInfo.CompressImageSegment(this.jdField_d_of_type_Int));
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject1 = ((Stream)localObject1).map(new ImageInfo.UploadMediaSegment(0, paramXMediaEditor, paramXMediaEditor.a("troopuin")));
    }
    for (;;)
    {
      localObject2 = paramXMediaEditor.findViewHolderForLayoutPosition(this.jdField_c_of_type_Int);
      if ((localObject2 instanceof ImageItem.ImageViewHolder))
      {
        localObject2 = (ImageItem.ImageViewHolder)localObject2;
        if (this.jdField_d_of_type_JavaLangString.equals(((ImageItem.ImageViewHolder)localObject2).a.getTag())) {
          ((ImageItem)((XMediaEditorAdapter)paramXMediaEditor.getAdapter()).a.a(1)).a((ImageItem.ImageViewHolder)localObject2, this, 0);
        }
      }
      return ((Stream)localObject1).map(new UIThreadOffFunction(null));
    }
  }
  
  public TroopHomeworkHelper.UploadFileTask a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = new TroopHomeworkHelper.UploadFileTask(PlayModeUtils.a(), paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      return paramString2;
    }
    return (TroopHomeworkHelper.UploadFileTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "img");
      localJSONObject.put("url", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("width", this.jdField_a_of_type_Int);
      localJSONObject.put("height", this.jdField_b_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ImageInfo", 2, "ImageInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (FileUtil.b(this.jdField_a_of_type_JavaLangString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, localOptions);
      this.jdField_a_of_type_Int = localOptions.outWidth;
      this.jdField_b_of_type_Int = localOptions.outHeight;
      int i = JpegExifReader.readOrientation(this.jdField_a_of_type_JavaLangString);
      if ((i == 6) || (i == 5) || (i == 8) || (i == 7))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize need orientation. before width=", Integer.valueOf(this.jdField_a_of_type_Int), ", height=", Integer.valueOf(this.jdField_b_of_type_Int), ", path=", this.jdField_a_of_type_JavaLangString });
        }
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize result. width=", Integer.valueOf(this.jdField_a_of_type_Int), ", height=", Integer.valueOf(this.jdField_b_of_type_Int), ", path=", this.jdField_a_of_type_JavaLangString, ", cost=", Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageInfo", 2, new Object[] { "ImageInfo createFrom json: ", paramJSONObject });
    }
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    c(paramJSONObject.optString("url"));
    this.jdField_a_of_type_Int = paramJSONObject.optInt("width");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("height");
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new File(paramString).toURI().toURL();
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageInfo", 1, "setURLFromPath exception.");
    }
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL(paramString);
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageInfo", 1, "Image setURLFromContentUrl exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
 * JD-Core Version:    0.7.0.1
 */