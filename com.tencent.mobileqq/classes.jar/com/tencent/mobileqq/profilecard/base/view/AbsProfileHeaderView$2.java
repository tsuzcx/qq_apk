package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import azfe;
import bggl;
import bghy;
import bglf;
import bgmo;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

class AbsProfileHeaderView$2
  implements Runnable
{
  AbsProfileHeaderView$2(AbsProfileHeaderView paramAbsProfileHeaderView, int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString) {}
  
  public void run()
  {
    Object localObject3 = null;
    Exception localException2 = null;
    Object localObject5 = null;
    int i = this.this$0.getResources().getDimensionPixelSize(2131297147);
    Object localObject1 = (AvatarLayout)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (ImageView)localObject1;
      if ((3 != this.jdField_a_of_type_Int) && ((localObject1 instanceof DynamicAvatarView))) {
        ((DynamicAvatarView)localObject1).e = "";
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label276;
      }
      localObject3 = localObject5;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject3 = localObject5;
        if (!bghy.a()) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = bghy.b();
        localObject5 = new File((String)localObject1);
        localObject3 = new BitmapFactory.Options();
        localObject5 = new FileInputStream((File)localObject5);
        ((BitmapFactory.Options)localObject3).inSampleSize = ((int)bgmo.a((InputStream)localObject5, i, i));
        ((InputStream)localObject5).close();
        localObject1 = bggl.a((String)localObject1, (BitmapFactory.Options)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {}
      }
      catch (Exception localException1)
      {
        localObject1 = localException2;
        localException2 = localException1;
      }
      try
      {
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = QQAppInterface.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_JavaLangString, true);
        }
        if (localObject1 != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AbsProfileHeaderView.2.1(this, (Bitmap)localObject1));
        }
        return;
      }
      catch (Exception localException3)
      {
        Object localObject4;
        break label252;
      }
      localObject1 = ((AvatarLayout)localObject1).a(0);
      break;
      label252:
      localObject4 = localObject1;
      label395:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, localException2.toString());
        localObject4 = localObject1;
        continue;
        label276:
        if (1 == this.jdField_a_of_type_Int)
        {
          localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11, this.jdField_a_of_type_JavaLangString, (byte)3, true, 0);
        }
        else
        {
          if (3 == this.jdField_a_of_type_Int)
          {
            if ((localObject1 instanceof DynamicAvatarView))
            {
              localObject1 = (DynamicAvatarView)localObject1;
              ((DynamicAvatarView)localObject1).e = bglf.a(this.this$0.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k);
              if (!bglf.a(((DynamicAvatarView)localObject1).e)) {
                break label395;
              }
              ((DynamicAvatarView)localObject1).setTextSize(this.this$0.getContext().getResources().getDimensionPixelSize(2131298946));
            }
            for (;;)
            {
              try
              {
                localObject1 = BitmapFactory.decodeResource(this.this$0.getContext().getResources(), 2130842050);
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                Object localObject2 = localObject4;
              }
              ((DynamicAvatarView)localObject1).setTextSize(this.this$0.getContext().getResources().getDimensionPixelSize(2131298947));
            }
          }
          if (2 == this.jdField_a_of_type_Int) {
            localObject1 = bgmo.b();
          } else {
            localObject1 = bgmo.a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.2
 * JD-Core Version:    0.7.0.1
 */