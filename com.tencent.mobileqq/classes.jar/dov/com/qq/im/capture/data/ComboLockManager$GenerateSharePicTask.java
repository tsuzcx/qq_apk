package dov.com.qq.im.capture.data;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import bbbd;
import bbdj;
import bbdr;
import bbwg;
import bbwi;
import bjjk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class ComboLockManager$GenerateSharePicTask
  implements Runnable
{
  Bundle a;
  
  public void run()
  {
    Object localObject1 = null;
    boolean bool = true;
    this.a.getInt("k_s_t");
    String str1 = this.a.getString("k_f_id");
    Object localObject2 = this.this$0.a(str1);
    int i;
    if (localObject2 == null)
    {
      i = -2;
      if (QLog.isColorLevel()) {
        QLog.i("FilterComboShare", 2, "GenerateSharePicTask result " + i + " exist" + bbdj.a((String)localObject1));
      }
      localObject2 = (AnimationDrawable)BaseApplicationImpl.getContext().getResources().getDrawable(2130843884);
      localObject2 = this.this$0;
      if (i != 1) {
        break label431;
      }
    }
    for (;;)
    {
      for (;;)
      {
        ComboLockManager.a((ComboLockManager)localObject2, bool, (String)localObject1, str1);
        return;
        Object localObject3 = ((LockedCategory)localObject2).c;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          i = -3;
          break;
        }
        if ((bbbd.a()) && (bbbd.b() < 20971520L))
        {
          QLog.e("FilterComboShare", 1, "download err no space");
          i = -4;
          break;
        }
        localObject2 = new File(ComboLockManager.jdField_a_of_type_JavaLangString);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = ComboLockManager.jdField_a_of_type_JavaLangString + str1;
        localObject3 = new bbwg((String)localObject3, new File((String)localObject2));
        ((bbwg)localObject3).n = true;
        ((bbwg)localObject3).b = 2;
        ((bbwg)localObject3).jdField_a_of_type_JavaLangString = str1;
        if (bbwi.a((bbwg)localObject3, null, null) != 0)
        {
          i = -5;
          break;
        }
        if (!QQAppInterface.class.isInstance(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface))
        {
          i = -6;
          break;
        }
        localObject1 = (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface;
        localObject3 = ((QQAppInterface)localObject1).c();
        String str2 = ((QQAppInterface)localObject1).getCurrentNickname();
        Bitmap localBitmap = ((QQAppInterface)localObject1).a((String)localObject3, true);
        localObject1 = (String)localObject2 + "_merge_" + (String)localObject3;
        localObject3 = bjjk.a((String)localObject2, 0.5F, 0.64F, localBitmap, str2, (String)localObject3);
        if (localObject3 == null)
        {
          i = -7;
          break;
        }
        try
        {
          bbdr.b((Bitmap)localObject3, 90, new File((String)localObject1));
          bbdj.d((String)localObject2);
          i = 1;
        }
        catch (IOException localIOException)
        {
          QLog.e("FilterComboShare", 1, "saveBitmapFileAsJPEG err", localIOException);
          i = -8;
        }
      }
      break;
      label431:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.ComboLockManager.GenerateSharePicTask
 * JD-Core Version:    0.7.0.1
 */