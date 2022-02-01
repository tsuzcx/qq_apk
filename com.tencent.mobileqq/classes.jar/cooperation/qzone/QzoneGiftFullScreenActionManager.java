package cooperation.qzone;

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
  public static final String MAGICFACE_RECEIVE_SOUND = "receiveSound";
  public static final String MAGICFACE_RECEIVE_XML = "receive.xml";
  public static final String TAG = "QzoneGiftFullScreenActionManager";
  ActionGlobalData actionGlobalData = null;
  Action currentMagicfaceAction;
  String epId;
  volatile boolean isRelease = false;
  volatile boolean isShutDown = false;
  volatile boolean isStart = false;
  MagicfaceActionDecoder magicfaceActionDecoder;
  QzoneGiftFullScreenActionManager.MagicfaceActionListener magicfaceActionListener;
  List<Action> magicfaceActions;
  QzoneGiftFullScreenActionManager.MagicfaceCloseListener magicfaceCloseListener;
  MagicfacePlayManager magicfacePlayManager;
  MagicfaceResLoader magicfaceResLoader;
  QzoneGiftFullScreenViewController magicfaceViewController;
  SoundPoolUtil soundPoolUtil;
  
  public QzoneGiftFullScreenActionManager(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController)
  {
    this.magicfaceViewController = paramQzoneGiftFullScreenViewController;
    this.magicfaceActionDecoder = new MagicfaceActionDecoder();
    this.soundPoolUtil = new SoundPoolUtil();
  }
  
  private void filterAction()
  {
    Object localObject = this.actionGlobalData;
    int j = 0;
    if ((localObject != null) && (!"non-ver".equals(((ActionGlobalData)localObject).f)))
    {
      localObject = splitVersion("8.8.17");
      int[] arrayOfInt = splitVersion(this.actionGlobalData.f);
      if ((localObject != null) && (arrayOfInt != null) && (localObject.length == arrayOfInt.length))
      {
        i = 0;
        while ((i < arrayOfInt.length) && (localObject[i] <= arrayOfInt[i]))
        {
          if (localObject[i] < arrayOfInt[i])
          {
            i = j;
            break label109;
          }
          i += 1;
        }
      }
      int i = 1;
      label109:
      this.magicfaceActions = getValidActions(i ^ 0x1);
      return;
    }
    this.magicfaceActions = getValidActions(false);
  }
  
  public static String getGiftFullScreenFolderPath(String paramString)
  {
    String str = CacheManager.getGifFullScreenDir();
    Object localObject = new File(str);
    if (!((File)localObject).isDirectory()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getPassiveFullScreenFolderPath(String paramString)
  {
    String str = CacheManager.getPraiseDir();
    Object localObject = new File(str);
    if (!((File)localObject).isDirectory()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  private List<Action> getValidActions(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.magicfaceActions.iterator();
    while (localIterator.hasNext())
    {
      Action localAction = (Action)localIterator.next();
      if (localAction != null) {
        if (paramBoolean)
        {
          if ("default".equals(localAction.b))
          {
            localArrayList.add(localAction);
            return localArrayList;
          }
        }
        else if (!"default".equals(localAction.b)) {
          localArrayList.add(localAction);
        }
      }
    }
    return localArrayList;
  }
  
  public static ActionGlobalData hasAction(String paramString1, String paramString2)
  {
    paramString1 = new MagicfaceResLoader(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new MagicfaceActionDecoder().b(paramString1);
  }
  
  private void initActionData(String paramString)
  {
    this.isStart = true;
    this.isShutDown = false;
    this.magicfacePlayManager.a();
    this.magicfaceResLoader = new MagicfaceResLoader(paramString);
    this.magicfacePlayManager.a(this.magicfaceResLoader);
    this.magicfacePlayManager.a(this.soundPoolUtil);
  }
  
  private void onEndMagicface(ActionGlobalData paramActionGlobalData)
  {
    Object localObject = this.magicfaceCloseListener;
    if (localObject != null) {
      ((QzoneGiftFullScreenActionManager.MagicfaceCloseListener)localObject).magicfaceClose();
    }
    this.isStart = false;
    localObject = this.magicfaceActionListener;
    if (localObject != null) {
      ((QzoneGiftFullScreenActionManager.MagicfaceActionListener)localObject).magicfaceActionEnd(paramActionGlobalData);
    }
  }
  
  private void onStartMagicface(ActionGlobalData paramActionGlobalData)
  {
    QzoneGiftFullScreenActionManager.MagicfaceActionListener localMagicfaceActionListener = this.magicfaceActionListener;
    if (localMagicfaceActionListener != null) {
      localMagicfaceActionListener.magicfaceActionStart(paramActionGlobalData);
    }
    if ((paramActionGlobalData != null) && (paramActionGlobalData.m != null)) {
      paramActionGlobalData.a();
    }
  }
  
  private int[] splitVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    arrayOfInt = new int[3];
    int j = 0;
    int i = 0;
    while (i < 3)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    paramString = paramString.split("\\.");
    if ((paramString != null) && (paramString.length > 1))
    {
      i = j;
      try
      {
        while (i < arrayOfInt.length)
        {
          arrayOfInt[i] = Integer.valueOf(paramString[i]).intValue();
          i += 1;
        }
        return arrayOfInt;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void close(QzoneGiftFullScreenActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.magicfaceCloseListener = paramMagicfaceCloseListener;
    }
    this.isShutDown = true;
    paramMagicfaceCloseListener = this.currentMagicfaceAction;
    if (paramMagicfaceCloseListener != null) {
      paramMagicfaceCloseListener.e();
    }
    paramMagicfaceCloseListener = this.actionGlobalData;
    if (paramMagicfaceCloseListener != null) {
      paramMagicfaceCloseListener.a(null);
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
    ActionGlobalData localActionGlobalData = this.actionGlobalData;
    if (localActionGlobalData != null) {
      localActionGlobalData.n = true;
    }
  }
  
  public void release()
  {
    this.isRelease = true;
    Object localObject = this.actionGlobalData;
    if (localObject != null) {
      ((ActionGlobalData)localObject).a(null);
    }
    localObject = this.magicfacePlayManager;
    if (localObject != null)
    {
      ((MagicfacePlayManager)localObject).a(null);
      this.magicfacePlayManager.c();
    }
    localObject = this.soundPoolUtil;
    if (localObject != null)
    {
      ((SoundPoolUtil)localObject).a();
      this.soundPoolUtil = null;
    }
    this.magicfaceViewController = null;
  }
  
  public void setMagicfaceActionListener(QzoneGiftFullScreenActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.magicfaceActionListener = paramMagicfaceActionListener;
  }
  
  public void setMagicfacePlayManager(MagicfacePlayManager paramMagicfacePlayManager)
  {
    this.magicfacePlayManager = paramMagicfacePlayManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager
 * JD-Core Version:    0.7.0.1
 */