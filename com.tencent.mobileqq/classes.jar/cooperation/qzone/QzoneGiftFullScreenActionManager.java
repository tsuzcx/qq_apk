package cooperation.qzone;

import android.content.SharedPreferences;
import android.text.TextUtils;
import awrl;
import awrn;
import awrq;
import awsc;
import awsn;
import awso;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QzoneGiftFullScreenActionManager
{
  public static final String MAGICFACE_RECEIVE_SOUND = "receiveSound";
  public static final String MAGICFACE_RECEIVE_XML = "receive.xml";
  public static final String TAG = "QzoneGiftFullScreenActionManager";
  awrn actionGlobalData = null;
  awrl currentMagicfaceAction;
  String epId;
  volatile boolean isRelease = false;
  volatile boolean isShutDown = false;
  volatile boolean isStart = false;
  awrq magicfaceActionDecoder;
  QzoneGiftFullScreenActionManager.MagicfaceActionListener magicfaceActionListener;
  List<awrl> magicfaceActions;
  QzoneGiftFullScreenActionManager.MagicfaceCloseListener magicfaceCloseListener;
  awsn magicfacePlayManager;
  awsc magicfaceResLoader;
  QzoneGiftFullScreenViewController magicfaceViewController;
  awso soundPoolUtil;
  
  public QzoneGiftFullScreenActionManager(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController)
  {
    this.magicfaceViewController = paramQzoneGiftFullScreenViewController;
    this.magicfaceActionDecoder = new awrq();
    this.soundPoolUtil = new awso();
  }
  
  private void filterAction()
  {
    boolean bool = false;
    if ((this.actionGlobalData == null) || ("non-ver".equals(this.actionGlobalData.b)))
    {
      this.magicfaceActions = getValidActions(false);
      return;
    }
    int[] arrayOfInt1 = splitVersion("8.4.10");
    int[] arrayOfInt2 = splitVersion(this.actionGlobalData.b);
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
      this.magicfaceActions = getValidActions(bool);
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
  
  public static String getGiftFullScreenFolderPath(String paramString)
  {
    String str = CacheManager.getGifFullScreenDir();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  public static String getPassiveFullScreenFolderPath(String paramString)
  {
    String str = CacheManager.getPraiseDir();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<awrl> getValidActions(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.magicfaceActions.iterator();
    for (;;)
    {
      awrl localawrl;
      if (localIterator.hasNext())
      {
        localawrl = (awrl)localIterator.next();
        if (localawrl == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localawrl.a)) {
            continue;
          }
          localArrayList.add(localawrl);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localawrl.a)) {
        localArrayList.add(localawrl);
      }
    }
  }
  
  public static awrn hasAction(String paramString1, String paramString2)
  {
    paramString1 = new awsc(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new awrq().a(paramString1);
  }
  
  private void initActionData(String paramString)
  {
    this.isStart = true;
    this.isShutDown = false;
    this.magicfacePlayManager.a();
    this.magicfaceResLoader = new awsc(paramString);
    this.magicfacePlayManager.a(this.magicfaceResLoader);
    this.magicfacePlayManager.a(this.soundPoolUtil);
  }
  
  private void onEndMagicface(awrn paramawrn)
  {
    if (this.magicfaceCloseListener != null) {
      this.magicfaceCloseListener.magicfaceClose();
    }
    this.isStart = false;
    if (this.magicfaceActionListener != null) {
      this.magicfaceActionListener.magicfaceActionEnd(paramawrn);
    }
  }
  
  private void onStartMagicface(awrn paramawrn)
  {
    if (this.magicfaceActionListener != null) {
      this.magicfaceActionListener.magicfaceActionStart(paramawrn);
    }
    if ((paramawrn != null) && (paramawrn.a != null)) {
      paramawrn.a();
    }
  }
  
  private int[] splitVersion(String paramString)
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
  
  public void close(QzoneGiftFullScreenActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.magicfaceCloseListener = paramMagicfaceCloseListener;
    }
    this.isShutDown = true;
    if (this.currentMagicfaceAction != null) {
      this.currentMagicfaceAction.d();
    }
    if (this.actionGlobalData != null) {
      this.actionGlobalData.a(null);
    }
  }
  
  public void doAction(String paramString1, String paramString2)
  {
    if (this.isStart) {
      return;
    }
    this.epId = paramString1;
    ThreadManager.post(new QzoneGiftFullScreenActionManager.1(this, paramString2), 8, null, true);
  }
  
  public boolean getPreferencesReceiveSound()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public boolean isStart()
  {
    return this.isStart;
  }
  
  public void openSound(boolean paramBoolean)
  {
    if (this.actionGlobalData != null) {
      this.actionGlobalData.d = true;
    }
  }
  
  public void release()
  {
    this.isRelease = true;
    if (this.actionGlobalData != null) {
      this.actionGlobalData.a(null);
    }
    if (this.magicfacePlayManager != null)
    {
      this.magicfacePlayManager.a(null);
      this.magicfacePlayManager.c();
    }
    if (this.soundPoolUtil != null)
    {
      this.soundPoolUtil.a();
      this.soundPoolUtil = null;
    }
    this.magicfaceViewController = null;
  }
  
  public void setMagicfaceActionListener(QzoneGiftFullScreenActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.magicfaceActionListener = paramMagicfaceActionListener;
  }
  
  public void setMagicfacePlayManager(awsn paramawsn)
  {
    this.magicfacePlayManager = paramawsn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager
 * JD-Core Version:    0.7.0.1
 */