package cooperation.qzone;

import android.content.SharedPreferences;
import android.text.TextUtils;
import avlg;
import avli;
import avll;
import avlx;
import avmi;
import avmj;
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
  avli actionGlobalData = null;
  avlg currentMagicfaceAction;
  String epId;
  volatile boolean isRelease = false;
  volatile boolean isShutDown = false;
  volatile boolean isStart = false;
  avll magicfaceActionDecoder;
  QzoneGiftFullScreenActionManager.MagicfaceActionListener magicfaceActionListener;
  List<avlg> magicfaceActions;
  QzoneGiftFullScreenActionManager.MagicfaceCloseListener magicfaceCloseListener;
  avmi magicfacePlayManager;
  avlx magicfaceResLoader;
  QzoneGiftFullScreenViewController magicfaceViewController;
  avmj soundPoolUtil;
  
  public QzoneGiftFullScreenActionManager(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController)
  {
    this.magicfaceViewController = paramQzoneGiftFullScreenViewController;
    this.magicfaceActionDecoder = new avll();
    this.soundPoolUtil = new avmj();
  }
  
  private void filterAction()
  {
    boolean bool = false;
    if ((this.actionGlobalData == null) || ("non-ver".equals(this.actionGlobalData.b)))
    {
      this.magicfaceActions = getValidActions(false);
      return;
    }
    int[] arrayOfInt1 = splitVersion("8.4.8");
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
  
  private List<avlg> getValidActions(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.magicfaceActions.iterator();
    for (;;)
    {
      avlg localavlg;
      if (localIterator.hasNext())
      {
        localavlg = (avlg)localIterator.next();
        if (localavlg == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localavlg.a)) {
            continue;
          }
          localArrayList.add(localavlg);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localavlg.a)) {
        localArrayList.add(localavlg);
      }
    }
  }
  
  public static avli hasAction(String paramString1, String paramString2)
  {
    paramString1 = new avlx(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new avll().a(paramString1);
  }
  
  private void initActionData(String paramString)
  {
    this.isStart = true;
    this.isShutDown = false;
    this.magicfacePlayManager.a();
    this.magicfaceResLoader = new avlx(paramString);
    this.magicfacePlayManager.a(this.magicfaceResLoader);
    this.magicfacePlayManager.a(this.soundPoolUtil);
  }
  
  private void onEndMagicface(avli paramavli)
  {
    if (this.magicfaceCloseListener != null) {
      this.magicfaceCloseListener.magicfaceClose();
    }
    this.isStart = false;
    if (this.magicfaceActionListener != null) {
      this.magicfaceActionListener.magicfaceActionEnd(paramavli);
    }
  }
  
  private void onStartMagicface(avli paramavli)
  {
    if (this.magicfaceActionListener != null) {
      this.magicfaceActionListener.magicfaceActionStart(paramavli);
    }
    if ((paramavli != null) && (paramavli.a != null)) {
      paramavli.a();
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
  
  public void setMagicfacePlayManager(avmi paramavmi)
  {
    this.magicfacePlayManager = paramavmi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager
 * JD-Core Version:    0.7.0.1
 */