package dov.com.qq.im.capture.paster;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
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
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  QIMInformationPasterManager.InformationPasterResDownloader jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager$InformationPasterResDownloader = null;
  private WeakReference<RelativeLayout> jdField_a_of_type_JavaLangRefWeakReference = null;
  private ConcurrentLinkedQueue<InfomationFacePackage.Item> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(InfomationFacePackage.Item paramItem)
  {
    paramItem = paramItem.g + "_" + paramItem.f + ".zip";
    return new File(jdField_a_of_type_JavaIoFile, paramItem).getPath();
  }
  
  public static String b(InfomationFacePackage.Item paramItem)
  {
    return jdField_a_of_type_JavaLangString + paramItem.g + "_" + paramItem.f + File.separator + paramItem.g;
  }
  
  private boolean d(InfomationFacePackage.Item paramItem)
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
          break label229;
        }
        int j = arrayOfString.length;
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i >= j) {
          break label232;
        }
        str = arrayOfString[i];
        bool2 = bool1;
        if (str.startsWith(paramItem.g))
        {
          if (!str.endsWith(".zip")) {
            break label151;
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
        label151:
        if (str.endsWith(paramItem.f))
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
              FileUtils.a(jdField_a_of_type_JavaLangString + str, false);
              bool2 = bool1;
            }
          }
        }
      }
      label229:
      boolean bool2 = false;
      label232:
      return bool2;
    }
    return false;
  }
  
  public void a()
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
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)paramDoodleEmojiItem.next();
      if ((localItem.b == 1) && (!a(localItem))) {
        a(localItem, new QIMInformationPasterManager.3(this));
      }
    }
  }
  
  public void a(InfomationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    ThreadManager.postImmediately(new QIMInformationPasterManager.1(this, paramItem, paramIInformationPasterResDownloaderCallback), null, true);
  }
  
  public void a(List<InfomationFacePackage.Item> paramList)
  {
    ThreadManager.postImmediately(new QIMInformationPasterManager.2(this, paramList), null, true);
  }
  
  public boolean a(InfomationFacePackage.Item paramItem)
  {
    if (TextUtils.isEmpty(paramItem.e)) {
      if (paramItem.a != 7) {}
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          return true;
        } while (!d(paramItem));
        localObject = b(paramItem);
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "checkDir:" + (String)localObject);
        }
        localObject = new File((String)localObject);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length != InformationFaceConstant.a(paramItem)));
    return true;
  }
  
  public boolean b(InfomationFacePackage.Item paramItem)
  {
    return this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager$InformationPasterResDownloader.a(paramItem.e);
  }
  
  public boolean c(InfomationFacePackage.Item paramItem)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + paramItem.g + "_" + paramItem.f);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + localFile.getAbsolutePath());
      }
      ZipUtils.unZipFile(new File(a(paramItem)), localFile.getAbsolutePath() + File.separator);
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
  
  public void onDestroy() {}
  
  public void onInit()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager
 * JD-Core Version:    0.7.0.1
 */