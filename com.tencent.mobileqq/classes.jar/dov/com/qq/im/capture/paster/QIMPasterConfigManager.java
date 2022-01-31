package dov.com.qq.im.capture.paster;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
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
    boolean bool1 = new File(jdField_a_of_type_JavaIoFile + File.separator + "doodle_sticker_config.cfg").exists();
    boolean bool2 = new File(QIMMusicConfigManager.jdField_a_of_type_JavaIoFile, "temp_sticker_zip").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPasterConfigManager", 2, "isStickerConfigFileExist" + bool1 + " " + bool2);
    }
    return (bool2) && (bool1);
  }
  
  /* Error */
  public ArrayList a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +166 -> 172
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   15: ifnonnull +155 -> 170
    //   18: getstatic 24	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   21: ldc 101
    //   23: invokestatic 130	dov/com/qq/im/capture/util/QIMFileUtils:a	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_0
    //   28: aload_0
    //   29: aload_3
    //   30: invokespecial 132	dov/com/qq/im/capture/paster/QIMPasterConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   33: putfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +48 -> 87
    //   42: new 87	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   49: ldc 134
    //   51: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 136
    //   60: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: ifnull +109 -> 177
    //   71: iconst_1
    //   72: istore_1
    //   73: ldc 77
    //   75: iconst_2
    //   76: aload_3
    //   77: iload_1
    //   78: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   81: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   91: ifnull +13 -> 104
    //   94: aload_0
    //   95: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   98: invokevirtual 139	java/util/ArrayList:size	()I
    //   101: ifne +69 -> 170
    //   104: ldc 141
    //   106: invokestatic 144	dov/com/qq/im/capture/util/QIMFileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_0
    //   111: aload_0
    //   112: aload_3
    //   113: invokespecial 132	dov/com/qq/im/capture/paster/QIMPasterConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   116: putfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   119: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +48 -> 170
    //   125: new 87	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   132: ldc 146
    //   134: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_3
    //   138: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 136
    //   143: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   151: ifnull +31 -> 182
    //   154: iload_2
    //   155: istore_1
    //   156: ldc 77
    //   158: iconst_2
    //   159: aload_3
    //   160: iload_1
    //   161: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_0
    //   173: getfield 127	dov/com/qq/im/capture/paster/QIMPasterConfigManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   176: areturn
    //   177: iconst_0
    //   178: istore_1
    //   179: goto -106 -> 73
    //   182: iconst_0
    //   183: istore_1
    //   184: goto -28 -> 156
    //   187: astore_3
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_3
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	QIMPasterConfigManager
    //   72	112	1	bool1	boolean
    //   1	154	2	bool2	boolean
    //   26	134	3	localObject1	Object
    //   187	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	71	187	finally
    //   73	87	187	finally
    //   87	104	187	finally
    //   104	154	187	finally
    //   156	170	187	finally
    //   170	172	187	finally
    //   188	190	187	finally
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