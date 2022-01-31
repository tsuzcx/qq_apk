package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import aoap;
import aoas;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.util.PasterUtil;
import dov.com.qq.im.capture.util.PasterUtil.Position;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.net.MalformedURLException;
import java.util.List;

public class InformationFaceAdapter
  extends BaseFaceListAdapter
  implements View.OnClickListener
{
  public InformationFaceAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ImageView paramImageView, Boolean paramBoolean, InfomationFacePackage.Item paramItem)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      float f = (float)((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_Double;
      paramImageView = PasterUtil.a();
      this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener.a(paramItem, paramImageView.a, paramImageView.b, f);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new aoas(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), ((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), this);; paramView = (aoas)paramView) {
      try
      {
        paramView.a((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage, paramInt, getCount());
        return paramView;
      }
      catch (MalformedURLException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        return paramView;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131371828);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131371829);
    int i = ((Integer)localImageView.getTag(2131362359)).intValue();
    InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131362361);
    QIMInformationPasterManager localQIMInformationPasterManager = (QIMInformationPasterManager)QIMManager.a().c(12);
    if (NetworkUtil.h(paramView.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "wifi, applyInfoPaster");
      }
      if (localQIMInformationPasterManager.a(localItem))
      {
        a(localImageView, localBoolean, localItem);
        return;
      }
      QQToast.a(paramView.getContext(), 0, "资源下载失败，请重启后重试", 0).a();
      return;
    }
    if (localQIMInformationPasterManager.a(localItem))
    {
      a(localImageView, localBoolean, localItem);
      return;
    }
    localQIMInformationPasterManager.a((InfomationFacePackage.Item)((InfomationFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_JavaUtilList.get(i), new aoap(this, localQIMCommonLoadingView, localImageView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */