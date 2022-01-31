package cooperation.qzone;

import amzz;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QzoneGiftFullScreenActionManager
{
  public Action a;
  public ActionGlobalData a;
  public MagicfaceActionDecoder a;
  public MagicfaceResLoader a;
  public MagicfacePlayManager a;
  SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  QzoneGiftFullScreenActionManager.MagicfaceActionListener jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceActionListener;
  QzoneGiftFullScreenActionManager.MagicfaceCloseListener jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceCloseListener;
  QzoneGiftFullScreenViewController jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController;
  String jdField_a_of_type_JavaLangString;
  public List a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public QzoneGiftFullScreenActionManager(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = null;
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController = paramQzoneGiftFullScreenViewController;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder = new MagicfaceActionDecoder();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = new SoundPoolUtil();
  }
  
  public static ActionGlobalData a(String paramString1, String paramString2)
  {
    paramString1 = new MagicfaceResLoader(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new MagicfaceActionDecoder().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = CacheManager.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      Action localAction;
      if (localIterator.hasNext())
      {
        localAction = (Action)localIterator.next();
        if (localAction == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localAction.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localAction);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localAction.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localAction);
      }
    }
  }
  
  private void a(ActionGlobalData paramActionGlobalData)
  {
    if (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceActionListener.a(paramActionGlobalData);
    }
    if ((paramActionGlobalData != null) && (paramActionGlobalData.a != null)) {
      paramActionGlobalData.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(paramString);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil);
  }
  
  private int[] a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    for (;;)
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      String[] arrayOfString = paramString.split("\\.");
      paramString = arrayOfInt;
      if (arrayOfString != null)
      {
        paramString = arrayOfInt;
        if (arrayOfString.length > 1)
        {
          i = j;
          paramString = arrayOfInt;
          try
          {
            if (i < arrayOfInt.length)
            {
              arrayOfInt[i] = Integer.valueOf(arrayOfString[i]).intValue();
              i += 1;
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
    return arrayOfInt;
  }
  
  public static String b(String paramString)
  {
    String str = CacheManager.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData == null) || ("non-ver".equals(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("7.6.8");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b);
    int i;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      this.jdField_a_of_type_JavaUtilList = a(bool);
      return;
      if (arrayOfInt1[i] < arrayOfInt2[i])
      {
        i = 0;
      }
      else
      {
        i += 1;
        break;
        i = 1;
      }
    }
  }
  
  private void b(ActionGlobalData paramActionGlobalData)
  {
    if (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceCloseListener != null) {
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceCloseListener.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceActionListener.b(paramActionGlobalData);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = null;
    }
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController = null;
  }
  
  public void a(MagicfacePlayManager paramMagicfacePlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = paramMagicfacePlayManager;
  }
  
  public void a(QzoneGiftFullScreenActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceActionListener = paramMagicfaceActionListener;
  }
  
  public void a(QzoneGiftFullScreenActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager$MagicfaceCloseListener = paramMagicfaceCloseListener;
    }
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    ThreadManager.post(new amzz(this, paramString2), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager
 * JD-Core Version:    0.7.0.1
 */