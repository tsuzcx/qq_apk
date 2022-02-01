package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

class RedPacketShowerFragment$1
  implements IPreloadRes.OnDownloadCallback
{
  RedPacketShowerFragment$1(RedPacketShowerFragment paramRedPacketShowerFragment, String paramString, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqPortalRedPacketShowerFragment.a != null))
    {
      if ((paramBoolean) && ((paramObject instanceof Bitmap)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketShowerFragment", 2, "initUI onDownload success,url = " + paramString);
        }
        paramObject = (Bitmap)paramObject;
        this.jdField_a_of_type_ComTencentMobileqqPortalRedPacketShowerFragment.a.setImageBitmap(paramObject);
      }
      if (!paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketShowerFragment", 2, "initUI onDownload failed,url = " + paramString);
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqPortalRedPacketShowerFragment.getResources().getDrawable(2130845531);
        if (!(paramString instanceof SkinnableBitmapDrawable)) {
          break label169;
        }
        paramString = ((SkinnableBitmapDrawable)paramString).getBitmap();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalRedPacketShowerFragment.a.setImageBitmap(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalEntryManager.b(this);
      return;
      label169:
      if ((paramString instanceof BitmapDrawable)) {
        paramString = ((BitmapDrawable)paramString).getBitmap();
      } else {
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment.1
 * JD-Core Version:    0.7.0.1
 */