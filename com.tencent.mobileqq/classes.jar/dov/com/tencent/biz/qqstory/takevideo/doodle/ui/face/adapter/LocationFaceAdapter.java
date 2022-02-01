package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.util.PasterUtil;
import dov.com.qq.im.capture.util.PasterUtil.Position;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import java.util.List;

public class LocationFaceAdapter
  extends BaseFaceListAdapter<LocationFacePackage>
  implements View.OnClickListener
{
  public LocationFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new LocationFaceAdapter.LocationItemLayout(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), ((LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), this);; localObject = (LocationFaceAdapter.LocationItemLayout)paramView)
    {
      ((LocationFaceAdapter.LocationItemLayout)localObject).a((LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage, paramInt, getCount(), a());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131370791);
    int i = ((Integer)((ImageView)localObject1).getTag(2131378913)).intValue();
    LocationFacePackage.Item localItem = (LocationFacePackage.Item)((LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_JavaUtilList.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131378891);
    int j;
    int k;
    float f;
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
    {
      localItem.a = ((ImageView)localObject1).getDrawable();
      localObject2 = localItem.a;
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        i = ((Drawable)localObject2).getIntrinsicWidth();
        j = ((ImageView)localObject1).getWidth();
        k = ((ImageView)localObject1).getPaddingLeft();
        if (j <= i) {
          break label206;
        }
        f = (((j - i) / 2 - k) * 2 + i) / i;
        f = (float)(f * ((LocationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_Double);
        localObject1 = PasterUtil.a();
        this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener.a(localItem, ((PasterUtil.Position)localObject1).a, ((PasterUtil.Position)localObject1).b, f);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label206:
      f = (i - (k + (i - j) / 2) * 2) / i;
      break;
      SLog.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */