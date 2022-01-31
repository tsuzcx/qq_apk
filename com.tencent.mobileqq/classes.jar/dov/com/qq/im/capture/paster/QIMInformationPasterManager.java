package dov.com.qq.im.capture.paster;

import amwu;
import amwv;
import amwx;
import android.annotation.TargetApi;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.util.QIMFileUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(16)
public class QIMInformationPasterManager
  extends IQIMManager
{
  private static File jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "information_paster");
  private static String b = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public QIMInformationPasterManager.InformationPasterResDownloader a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public QIMInformationPasterManager()
  {
    this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager$InformationPasterResDownloader = null;
    this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager$InformationPasterResDownloader = new QIMInformationPasterManager.InformationPasterResDownloader(this);
  }
  
  public static String a(InfomationFacePackage.Item paramItem)
  {
    paramItem = paramItem.f + "_" + paramItem.e + ".zip";
    return new File(jdField_a_of_type_JavaIoFile, paramItem).getPath();
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String b(InfomationFacePackage.Item paramItem)
  {
    return b + paramItem.f + "_" + paramItem.e + File.separator + paramItem.f;
  }
  
  private boolean c(InfomationFacePackage.Item paramItem)
  {
    if (jdField_a_of_type_JavaIoFile != null)
    {
      int i;
      boolean bool1;
      label44:
      String str;
      if (!jdField_a_of_type_JavaIoFile.exists())
      {
        jdField_a_of_type_JavaIoFile.mkdirs();
        String[] arrayOfString = jdField_a_of_type_JavaIoFile.list();
        if (arrayOfString == null) {
          break label261;
        }
        int j = arrayOfString.length;
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i >= j) {
          break label264;
        }
        str = arrayOfString[i];
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "check md5 filename:" + str);
        }
        bool2 = bool1;
        if (str.startsWith(paramItem.f))
        {
          if (!str.endsWith(".zip")) {
            break label183;
          }
          FileUtils.a(jdField_a_of_type_JavaIoFile + str, false);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break label44;
        if (jdField_a_of_type_JavaIoFile.isDirectory()) {
          break;
        }
        jdField_a_of_type_JavaIoFile.delete();
        jdField_a_of_type_JavaIoFile.mkdirs();
        break;
        label183:
        if (str.endsWith(paramItem.e))
        {
          bool2 = true;
        }
        else
        {
          bool2 = bool1;
          if (!str.endsWith("png"))
          {
            bool2 = bool1;
            if (!str.endsWith("tmp"))
            {
              FileUtils.a(b + str, false);
              bool2 = bool1;
            }
          }
        }
      }
      label261:
      boolean bool2 = false;
      label264:
      return bool2;
    }
    return false;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)paramDoodleEmojiItem.next();
      if ((localItem.b == 1) && (!a(localItem))) {
        a(localItem, new amwx(this));
      }
    }
  }
  
  public void a(InfomationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    ThreadManager.postImmediately(new amwu(this, paramItem, paramIInformationPasterResDownloaderCallback), null, true);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List paramList)
  {
    ThreadManager.postImmediately(new amwv(this, paramList), null, true);
  }
  
  public boolean a(InfomationFacePackage.Item paramItem)
  {
    if (TextUtils.isEmpty(paramItem.d)) {}
    Object localObject;
    do
    {
      return true;
      if (!c(paramItem)) {
        return false;
      }
      localObject = b(paramItem);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "checkDir:" + (String)localObject);
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        break;
      }
      localObject = ((File)localObject).list();
    } while ((localObject != null) && (localObject.length == InformationFaceConstant.a(paramItem)));
    return false;
  }
  
  public void b() {}
  
  public boolean b(InfomationFacePackage.Item paramItem)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(b + paramItem.f + "_" + paramItem.e);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + localFile.getAbsolutePath());
      }
      ZipUtils.a(new File(a(paramItem)), localFile.getAbsolutePath() + File.separator);
      bool = true;
    }
    catch (Exception paramItem)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIMInformationPasterManager", 2, paramItem, new Object[0]);
    }
    return bool;
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localRelativeLayout != null)
      {
        localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager
 * JD-Core Version:    0.7.0.1
 */