package com.tencent.mobileqq.hiboom;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class HiBoomFontDrawer$1
  implements Runnable
{
  HiBoomFontDrawer$1(HiBoomFontDrawer paramHiBoomFontDrawer, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((HiBoomFontDrawer)localObject).jdField_a_of_type_Int = ((HiBoomFontDrawer)localObject).a(this.a);
    int i = this.this$0.jdField_a_of_type_Int;
    boolean bool3 = true;
    StringBuilder localStringBuilder1;
    if ((i != 1) && (this.this$0.jdField_a_of_type_Int != 3))
    {
      if (this.this$0.jdField_a_of_type_Int == 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
        ((StringBuilder)localObject).append(this.this$0.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(this.this$0.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(".hb");
        localObject = new File(((StringBuilder)localObject).toString());
        String str = FileUtils.readFileToStringEx((File)localObject, -1);
        if (!TextUtils.isEmpty(str))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo = HiBoomInfo.a(str);
          if (this.this$0.jdField_a_of_type_AndroidGraphicsTypeface == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
            ((StringBuilder)localObject).append(this.this$0.jdField_b_of_type_Int);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append(this.this$0.jdField_b_of_type_Int);
            ((StringBuilder)localObject).append(".fz");
            localObject = ((StringBuilder)localObject).toString();
            if (FileUtils.fileExists((String)localObject))
            {
              try
              {
                this.this$0.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((String)localObject);
              }
              catch (Exception localException)
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("file error:");
                localStringBuilder2.append((String)localObject);
                QLog.e("HiBoomFont.FontDrawer", 2, localStringBuilder2.toString(), localException);
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
                ((StringBuilder)localObject).append(this.this$0.jdField_b_of_type_Int);
                FileUtils.deleteDirectory(((StringBuilder)localObject).toString());
                return;
              }
            }
            else
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("file is not exist, path=");
              localStringBuilder1.append((String)localObject);
              QLog.e("HiBoomFont.FontDrawer", 2, localStringBuilder1.toString());
            }
          }
          this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        else if ((!((File)localObject).exists()) && (this.a))
        {
          this.this$0.c.set(false);
          this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(this.this$0.jdField_b_of_type_Int);
        }
      }
      else if (this.this$0.jdField_a_of_type_Int == 4)
      {
        if (!((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isFZEngineInited())
        {
          HiBoomFont.a().c();
          QLog.d("HiBoomFont.FontDrawer", 2, "run: initFZEngine");
        }
        if (((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isFZSoLoaded())
        {
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo: initFont");
          }
          ThreadManager.getUIHandler().post(new HiBoomFontDrawer.1.1(this));
        }
        else
        {
          this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
      }
    }
    else
    {
      if (!HiBoomFont.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        HiBoomFont.a().b();
      }
      if (HiBoomFont.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo HYEngine Ready");
        }
        if (this.this$0.jdField_a_of_type_Int == 1) {
          localObject = ".hy";
        } else {
          localObject = ".hy3";
        }
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
        localStringBuilder1.append(this.this$0.jdField_b_of_type_Int);
        localStringBuilder1.append(File.separator);
        localStringBuilder1.append(this.this$0.jdField_b_of_type_Int);
        localStringBuilder1.append((String)localObject);
        localObject = localStringBuilder1.toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("initHiboom: path= ");
          localStringBuilder1.append((String)localObject);
          localStringBuilder1.append(" fontId=");
          localStringBuilder1.append(this.this$0.jdField_b_of_type_Int);
          QLog.d("HiBoomFont.FontDrawer", 2, localStringBuilder1.toString());
        }
        if (new File((String)localObject).exists())
        {
          boolean bool2 = HiBoomFont.a().jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.this$0.jdField_b_of_type_Int);
          boolean bool4 = HiBoomFont.a().jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.this$0.jdField_b_of_type_Int);
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = HiBoomFont.a().jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, this.this$0.jdField_b_of_type_Int, false);
          }
          bool2 = bool4;
          if (!bool4) {
            bool2 = HiBoomFont.a().jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, this.this$0.jdField_b_of_type_Int, false);
          }
          localObject = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
          if ((bool1) && (bool2)) {
            bool1 = bool3;
          } else {
            bool1 = false;
          }
          ((AtomicBoolean)localObject).set(bool1);
        }
        else if (this.a)
        {
          this.this$0.c.set(false);
          this.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(this.this$0.jdField_b_of_type_Int);
        }
      }
    }
    if (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      HiBoomFontDrawer.a(this.this$0);
    }
    this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1
 * JD-Core Version:    0.7.0.1
 */