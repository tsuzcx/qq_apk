package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.AtDoodleFragmentStategy;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig.Builder;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory;
import dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.FaceDrawableListener;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.Collections;
import java.util.List;

public class EditVideoAtDoodleController
  implements StoryFaceDrawableFactory.FaceDrawableListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public EditVideoAtDoodleController.DoodleEventListener a;
  private AtLayer jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer;
  private DoodleView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private ElasticImageView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  private StoryFaceDrawableFactory jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwStoryFaceDrawableFactory;
  
  public EditVideoAtDoodleController(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)paramRelativeLayout.findViewById(2131371644));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramRelativeLayout.findViewById(2131364370));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramRelativeLayout.findViewById(2131364371));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwStoryFaceDrawableFactory = new StoryFaceDrawableFactory(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwStoryFaceDrawableFactory.a(this);
    c();
    d();
  }
  
  public static String a(@NonNull String paramString)
  {
    if (paramString.getBytes().length <= 24)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk no need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
      return paramString;
    }
    SLog.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
    int k = "...".getBytes().length;
    Object localObject2 = paramString.substring(0, 8);
    int j = ((String)localObject2).getBytes().length;
    int i = 8;
    String str;
    for (Object localObject1 = localObject2; i <= paramString.length(); localObject1 = str)
    {
      if (j + k == 24)
      {
        SLog.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", localObject1 + "...", Integer.valueOf((localObject1 + "...").getBytes().length));
        return localObject1 + "...";
      }
      if (j + k > 24)
      {
        SLog.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", (String)localObject2 + "...", Integer.valueOf(((String)localObject2 + "...").getBytes().length));
        return (String)localObject2 + "...";
      }
      i += 1;
      str = paramString.substring(0, i);
      j = str.getBytes().length;
      localObject2 = localObject1;
    }
    return localObject1;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAtDoodleController$DoodleEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAtDoodleController$DoodleEventListener.a(paramInt);
    }
  }
  
  private void c()
  {
    DoodleConfig localDoodleConfig = new DoodleConfig.Builder().a(new AtDoodleFragmentStategy()).a(720).b(1280).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(localDoodleConfig);
  }
  
  private void d()
  {
    int i = 0;
    while (i < AtDoodleFragmentStategy.a.length)
    {
      AtLayer localAtLayer = (AtLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(AtDoodleFragmentStategy.a[i]);
      localAtLayer.a(new EditVideoAtDoodleController.LayerTouchListener(this));
      localAtLayer.a(new EditVideoAtDoodleController.LayerEventListener(this));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localAtLayer);
      i += 1;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer = ((AtLayer)this.jdField_a_of_type_AndroidUtilSparseArray.get(0));
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. Invalid index.");
      return 0;
    }
    AtLayer localAtLayer = (AtLayer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localAtLayer == null)
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. layer is null.");
      return 0;
    }
    return localAtLayer.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. Invalid index.");
      return null;
    }
    AtLayer localAtLayer = (AtLayer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localAtLayer == null)
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. layer is null.");
      return null;
    }
    return localAtLayer.b();
  }
  
  @NonNull
  public List a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size())) {
      return Collections.EMPTY_LIST;
    }
    AtLayer localAtLayer = (AtLayer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localAtLayer == null) {
      return Collections.EMPTY_LIST;
    }
    return localAtLayer.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.k();
    }
  }
  
  public void a(int paramInt)
  {
    SLog.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer. index:" + paramInt);
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Invalid index.");
      return;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Layer is null.");
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer = ((AtLayer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      AtLayer localAtLayer = (AtLayer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localAtLayer != null) {
        localAtLayer.a(false);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(EditVideoAtDoodleController.DoodleEventListener paramDoodleEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAtDoodleController$DoodleEventListener = paramDoodleEventListener;
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel uin = %s remark = %s name = %s.", paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.a(paramString1)) {
      return;
    }
    int i = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwStoryFaceDrawableFactory.a(paramString1, i, i);
    if (localDrawable == null)
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "createStoryFaceDrawable failed, uin=%s, width=%s, height=%s.", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(i) });
      return;
    }
    paramString2 = a(paramString2);
    AtLayer.LayerParams localLayerParams = DoodleUtil.a(this.jdField_a_of_type_AndroidContentContext, localDrawable, paramString2, 0);
    if (localLayerParams != null)
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.c() == 0) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.d() == 0))
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "Add the at label while the layer's size is 0. Force to set the layer's size to the screen's size.");
        i = ScreenUtil.a;
        int j = ScreenUtil.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.a(i, j);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.a(paramString1, localDrawable, paramString2, paramString3, localLayerParams, null);
      return;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel init params failed..");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramString);
  }
  
  public void b()
  {
    SLog.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "onDestory");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwStoryFaceDrawableFactory.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoAtDoodleController
 * JD-Core Version:    0.7.0.1
 */