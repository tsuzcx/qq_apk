package com.tencent.qidian;

import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$13
  extends AvatarObserver
{
  QidianProfileCardActivity$13(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    super.onUpdateCustomHead(paramBoolean, paramString);
    if (paramBoolean)
    {
      if (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)) {
        break label86;
      }
      if (!SimpleUIUtil.a()) {
        break label64;
      }
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.getFaceBitmap(paramString, (byte)2, false);
      this.a.c();
    }
    label64:
    label86:
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.getFaceBitmap(paramString, false);
      break;
      paramString = (QidianProfileCardActivity.PaGroupStruct)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } while (paramString == null);
    this.a.a(paramString.jdField_a_of_type_Int, (URLImageView)paramString.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.13
 * JD-Core Version:    0.7.0.1
 */