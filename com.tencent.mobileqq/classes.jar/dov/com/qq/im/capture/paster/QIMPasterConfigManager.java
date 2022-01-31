package dov.com.qq.im.capture.paster;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.util.QIMFileUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class QIMPasterConfigManager
  extends IQIMManager
{
  public static final File a;
  private ArrayList a;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "dov_doodle_sticker");
  }
  
  private ArrayList a(String paramString)
  {
    localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("category");
      localArrayList.ensureCapacity(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        if (i >= 50) {
          return localArrayList;
        }
        DoodleEmojiItem localDoodleEmojiItem = DoodleEmojiItem.getDoodleEmojiItemFromJsonObj(paramString.getJSONObject(i));
        if (localDoodleEmojiItem != null) {
          localArrayList.add(localDoodleEmojiItem);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMPasterConfigManager", 2, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_a_of_type_JavaIoFile + File.separator + "doodle_sticker_config.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPasterConfigManager", 2, "QIMPasterConfigManager isStickerConfigFileExist=" + bool);
    }
    return bool;
  }
  
  /* Error */
  public ArrayList a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +173 -> 179
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   15: ifnonnull +162 -> 177
    //   18: getstatic 24	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   21: ldc 101
    //   23: invokestatic 123	dov/com/qq/im/capture/util/QIMFileUtils:a	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +12 -> 43
    //   34: aload_0
    //   35: aload_0
    //   36: aload_3
    //   37: invokespecial 131	dov/com/qq/im/capture/paster/QIMPasterConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   40: putfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   43: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +48 -> 94
    //   49: new 87	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   56: ldc 133
    //   58: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_3
    //   62: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 135
    //   67: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: astore_3
    //   71: aload_0
    //   72: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: ifnull +109 -> 184
    //   78: iconst_1
    //   79: istore_1
    //   80: ldc 77
    //   82: iconst_2
    //   83: aload_3
    //   84: iload_1
    //   85: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_0
    //   95: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   98: ifnull +13 -> 111
    //   101: aload_0
    //   102: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   105: invokevirtual 138	java/util/ArrayList:size	()I
    //   108: ifne +69 -> 177
    //   111: ldc 140
    //   113: invokestatic 143	dov/com/qq/im/capture/util/QIMFileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_0
    //   118: aload_0
    //   119: aload_3
    //   120: invokespecial 131	dov/com/qq/im/capture/paster/QIMPasterConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   123: putfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   126: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +48 -> 177
    //   132: new 87	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   139: ldc 145
    //   141: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_3
    //   145: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 135
    //   150: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: astore_3
    //   154: aload_0
    //   155: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   158: ifnull +31 -> 189
    //   161: iload_2
    //   162: istore_1
    //   163: ldc 77
    //   165: iconst_2
    //   166: aload_3
    //   167: iload_1
    //   168: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_0
    //   180: getfield 120	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   183: areturn
    //   184: iconst_0
    //   185: istore_1
    //   186: goto -106 -> 80
    //   189: iconst_0
    //   190: istore_1
    //   191: goto -28 -> 163
    //   194: astore_3
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_3
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	QIMPasterConfigManager
    //   79	112	1	bool1	boolean
    //   1	161	2	bool2	boolean
    //   26	141	3	localObject1	Object
    //   194	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	43	194	finally
    //   43	78	194	finally
    //   80	94	194	finally
    //   94	111	194	finally
    //   111	161	194	finally
    //   163	177	194	finally
    //   177	179	194	finally
    //   195	197	194	finally
  }
  
  public void a()
  {
    a();
  }
  
  public void a(String paramString)
  {
    Object localObject = a(paramString);
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      ((DoodleEmojiManager)SuperManager.a(36)).a(this.jdField_a_of_type_JavaUtilArrayList);
      localObject = (PasterDataManager)QIMManager.a().c(4);
      if (((PasterDataManager)localObject).a != null) {
        ((PasterDataManager)localObject).a.clear();
      }
      a().notifyObservers(CaptureConfigUpdateObserver.class, 4, true, null);
      if (QLog.isColorLevel()) {
        QLog.i("QIMPasterConfigManager", 2, "paster config send notify");
      }
      QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "doodle_sticker_config.cfg", paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("paster config handleConfig").append(paramString).append(" result:");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label149;
      }
    }
    label149:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QIMPasterConfigManager", 2, bool);
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMPasterConfigManager
 * JD-Core Version:    0.7.0.1
 */