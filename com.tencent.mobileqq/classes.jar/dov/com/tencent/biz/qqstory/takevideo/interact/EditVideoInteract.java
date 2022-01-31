package dov.com.tencent.biz.qqstory.takevideo.interact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aokr;
import aoks;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tribe.async.async.JobSegment;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditInteractExport;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoVote;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer.InteractItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateInteractPasterImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateInteractPasterImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.Publishable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoInteract
  extends EditVideoPart
  implements DialogInterface.OnDismissListener, EditInteractExport, Publishable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private InteractPasterEditDialog jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog;
  @Nullable
  private InteractPasterItem.InteractPasterInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo;
  private float b;
  private float c;
  private float d;
  
  public EditVideoInteract(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private String a(InteractPasterItem.InteractPasterInfo paramInteractPasterInfo)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      InteractPasterLayer.InteractItem localInteractItem = (InteractPasterLayer.InteractItem)a().a();
      if (localInteractItem == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        paramInteractPasterInfo = new JSONArray(Arrays.asList(paramInteractPasterInfo.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", paramInteractPasterInfo);
        paramInteractPasterInfo = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(UIUtils.a(a())), Integer.valueOf(UIUtils.b(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localInteractItem.u * localInteractItem.q), Float.valueOf(localInteractItem.v * localInteractItem.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localInteractItem.a.x + localInteractItem.s), Float.valueOf(localInteractItem.a.y + localInteractItem.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", paramInteractPasterInfo);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localInteractItem.r);
        localJSONObject1.put("a", localJSONObject2);
        paramInteractPasterInfo = localJSONObject1.toString();
        return paramInteractPasterInfo;
      }
      catch (JSONException paramInteractPasterInfo)
      {
        SLog.e("Q.qqstory.publish.editEditVideoInteract", paramInteractPasterInfo.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.isShowing())) {
      c();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog = new InteractPasterEditDialog(a(), this, paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.a(a());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.setContentView(2130970920);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.setOnDismissListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.show();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.isShowing()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.dismiss();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog = null;
    }
  }
  
  public Bitmap a()
  {
    InteractPasterLayer localInteractPasterLayer = a();
    if (localInteractPasterLayer.a()) {}
    for (;;)
    {
      return null;
      int i = localInteractPasterLayer.a.width();
      int j = localInteractPasterLayer.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localInteractPasterLayer.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        SLog.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  public JobSegment a(int paramInt)
  {
    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource))) {
      return new HWEncodeGenerateInteractPasterImageSegment(this);
    }
    return new GenerateInteractPasterImageSegment(this);
  }
  
  @NonNull
  public InteractPasterLayer a()
  {
    Object localObject = (EditDoodleExport)a(EditDoodleExport.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((EditDoodleExport)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public InteractPasterItem.InteractPasterInfo a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo;
  }
  
  public void a()
  {
    super.a();
    a(EditInteractExport.class, this);
  }
  
  public void a(int paramInt, InteractPasterItem.InteractPasterInfo paramInteractPasterInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = paramInteractPasterInfo.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, paramInteractPasterInfo.jdField_a_of_type_ArrayOfAndroidGraphicsRect, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo = paramInteractPasterInfo;
    }
  }
  
  public void a(Bundle paramBundle, InteractPasterItem.InteractPasterInfo paramInteractPasterInfo)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, paramInteractPasterInfo);
  }
  
  public void a(InteractPasterLayer.InteractItem paramInteractItem, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    EditVideoVote.a(localBundle, paramInteractItem);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(38, localBundle);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterEditDialog.isShowing()))
    {
      c();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, GenerateContext paramGenerateContext)
  {
    InteractPasterItem.InteractPasterInfo localInteractPasterInfo = a();
    if (localInteractPasterInfo != null)
    {
      String str = a(localInteractPasterInfo);
      if (!TextUtils.isEmpty(str))
      {
        SLog.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        paramGenerateContext.a.putExtra("i_l", str);
        StoryReportor.a("video_edit", "pub_vote", 2, 0, new String[] { localInteractPasterInfo.jdField_a_of_type_ArrayOfJavaLangString[0] });
      }
      return;
    }
    SLog.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      c();
      return;
    }
    int i = -1;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        this.jdField_a_of_type_Float = paramObject.getFloat("scale");
        this.b = paramObject.getFloat("rotate");
        this.c = paramObject.getFloat("translateX");
        this.d = paramObject.getFloat("translateY");
        paramInt = paramObject.getInt("interact_type");
      }
    }
    if (paramInt != 1001) {
      throw new IllegalArgumentException("unSupport paster type:" + paramInt);
    }
    a(paramInt);
    a().c();
    StoryReportor.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      SLog.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    InteractPasterItem.InteractPasterInfo localInteractPasterInfo = a();
    if (localInteractPasterInfo == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localInteractPasterInfo.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localInteractPasterInfo.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localInteractPasterInfo.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    DialogUtil.a(a(), 230, "还没有输入问题哦", null, "我知道了", "输入", new aokr(this), new aoks(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.interact.EditVideoInteract
 * JD-Core Version:    0.7.0.1
 */