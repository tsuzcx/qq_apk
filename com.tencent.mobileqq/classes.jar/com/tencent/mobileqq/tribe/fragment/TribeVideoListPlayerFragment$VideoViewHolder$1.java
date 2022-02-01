package com.tencent.mobileqq.tribe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.playvideo.BaseTribeVideoItem;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class TribeVideoListPlayerFragment$VideoViewHolder$1
  implements BusinessObserver
{
  TribeVideoListPlayerFragment$VideoViewHolder$1(TribeVideoListPlayerFragment.VideoViewHolder paramVideoViewHolder, TribeVideoItem paramTribeVideoItem, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoListPlayerFragment", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity();
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = BaseApplicationImpl.getContext();
      if (paramBoolean)
      {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            break label540;
          }
          localObject2 = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject2).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject2).ret.get();
          paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject2).data.get());
          if (QLog.isColorLevel()) {
            QLog.i("TribeVideoListPlayerFragment", 2, "retCode = [" + paramInt + "]");
          }
          if (paramInt == 0) {
            break label267;
          }
          paramBundle = paramBundle.optString("msg");
          if (!TextUtils.isEmpty(paramBundle))
          {
            QQToast.a((Context)localObject1, 1, "" + paramBundle, 1).a();
            return;
          }
          QQToast.a((Context)localObject1, 1, HardCodeUtil.a(2131714980), 1).a();
          return;
        }
        catch (Exception paramBundle)
        {
          QQToast.a((Context)localObject1, 1, HardCodeUtil.a(2131714966), 1).a();
          if (!QLog.isColorLevel()) {
            break label637;
          }
        }
        QLog.e("TribeVideoListPlayerFragment", 2, "未知异常，请稍后重试", paramBundle);
        return;
        label267:
        if (paramBundle.optInt("retcode") != 0) {
          break label637;
        }
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem;
        if (this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.jdField_c_of_type_Boolean) {
          break label638;
        }
      }
    }
    label540:
    label637:
    label638:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramBundle.jdField_c_of_type_Boolean = paramBoolean;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (BaseTribeVideoItem)paramBundle.next();
        if (((localObject2 instanceof TribeVideoItem)) && (((TribeVideoItem)localObject2).jdField_c_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.jdField_c_of_type_Long)) {
          ((TribeVideoItem)localObject2).jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.jdField_c_of_type_Boolean;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.jdField_c_of_type_Boolean) {}
      for (paramBundle = HardCodeUtil.a(2131714981);; paramBundle = HardCodeUtil.a(2131714979))
      {
        QQToast.a((Context)localObject1, 2, paramBundle, 1).a();
        if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.jdField_a_of_type_Int) == this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem) && (this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.jdField_c_of_type_Boolean) && (TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference != null) && (TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((TribeVideoPlugin)TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.jdField_c_of_type_Long);
        }
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "follow_suc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.d, this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.b + "", "", this.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.l.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.k.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.f.clearAnimation();
      QQToast.a((Context)localObject1, 1, HardCodeUtil.a(2131714978), 1).a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.l.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.k.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoViewHolder.f.clearAnimation();
      QQToast.a((Context)localObject1, 1, HardCodeUtil.a(2131714963), 1).a();
      return;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.VideoViewHolder.1
 * JD-Core Version:    0.7.0.1
 */