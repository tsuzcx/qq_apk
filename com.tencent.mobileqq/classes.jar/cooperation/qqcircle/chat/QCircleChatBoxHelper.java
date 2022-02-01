package cooperation.qqcircle.chat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.QCircleConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QCircleChatBoxHelper
{
  private static final String LINK_KEY = "&";
  private static final String TAG = "QCircleChatBoxHelper";
  private static volatile QCircleChatBoxHelper sInstance;
  private Pair<Integer, List<String>> mUnReadInfo;
  private int mUnReadNum;
  private List<String> mUnReadUinList = new LinkedList();
  
  public static QCircleChatBoxHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleChatBoxHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void restoreUnReadInfo(int paramInt, List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append("&").append(str);
    }
    paramList = QCircleConfig.getQCircleSp();
    if (paramList != null)
    {
      paramList.edit().putString("qcircle_unread_message_info", localStringBuilder.toString()).apply();
      QLog.d("QCircleChatBoxHelper", 1, "restoreUnReadInfo unReadNum:" + paramInt);
    }
  }
  
  public void clearUnReadInfo()
  {
    try
    {
      QLog.d("QCircleChatBoxHelper", 1, "clearUnReadInfo");
      this.mUnReadNum = 0;
      this.mUnReadUinList = new LinkedList();
      this.mUnReadInfo = new Pair(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
      restoreUnReadInfo(0, this.mUnReadUinList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Pair<Integer, List<String>> getUnReadInfo()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   8: ifnull +43 -> 51
    //   11: ldc 11
    //   13: iconst_1
    //   14: new 40	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   21: ldc 128
    //   23: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   30: getfield 132	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   33: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: areturn
    //   51: aload_0
    //   52: new 109	com/tencent/util/Pair
    //   55: dup
    //   56: iconst_0
    //   57: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: new 27	java/util/LinkedList
    //   63: dup
    //   64: invokespecial 28	java/util/LinkedList:<init>	()V
    //   67: invokespecial 118	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   70: putfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   73: invokestatic 72	cooperation/qqcircle/QCircleConfig:getQCircleSp	()Landroid/content/SharedPreferences;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +142 -> 220
    //   81: aload_2
    //   82: ldc 80
    //   84: ldc 137
    //   86: invokeinterface 141 3 0
    //   91: astore_2
    //   92: aload_2
    //   93: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifne +124 -> 220
    //   99: aload_2
    //   100: ldc 8
    //   102: invokevirtual 151	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   105: astore_2
    //   106: aload_2
    //   107: arraylength
    //   108: iconst_1
    //   109: if_icmple +39 -> 148
    //   112: aload_0
    //   113: aload_2
    //   114: iconst_0
    //   115: aaload
    //   116: invokestatic 155	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   119: putfield 107	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadNum	I
    //   122: iload_1
    //   123: aload_2
    //   124: arraylength
    //   125: if_icmpge +23 -> 148
    //   128: aload_0
    //   129: getfield 30	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadUinList	Ljava/util/List;
    //   132: aload_2
    //   133: iload_1
    //   134: aaload
    //   135: invokeinterface 159 2 0
    //   140: pop
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: goto -23 -> 122
    //   148: ldc 11
    //   150: iconst_1
    //   151: new 40	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   158: ldc 161
    //   160: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: getfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   167: getfield 132	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   170: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: new 109	com/tencent/util/Pair
    //   183: dup
    //   184: aload_0
    //   185: getfield 107	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadNum	I
    //   188: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aload_0
    //   192: getfield 30	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadUinList	Ljava/util/List;
    //   195: invokespecial 118	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   198: putfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   201: aload_0
    //   202: getfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   205: astore_2
    //   206: goto -159 -> 47
    //   209: astore_2
    //   210: ldc 11
    //   212: iconst_1
    //   213: aload_2
    //   214: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: getfield 120	cooperation/qqcircle/chat/QCircleChatBoxHelper:mUnReadInfo	Lcom/tencent/util/Pair;
    //   224: astore_2
    //   225: goto -178 -> 47
    //   228: astore_2
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_2
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	QCircleChatBoxHelper
    //   1	144	1	i	int
    //   46	160	2	localObject1	Object
    //   209	5	2	localException	java.lang.Exception
    //   224	1	2	localPair	Pair
    //   228	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   73	77	209	java/lang/Exception
    //   81	122	209	java/lang/Exception
    //   122	141	209	java/lang/Exception
    //   148	206	209	java/lang/Exception
    //   4	47	228	finally
    //   51	73	228	finally
    //   73	77	228	finally
    //   81	122	228	finally
    //   122	141	228	finally
    //   148	206	228	finally
    //   210	220	228	finally
    //   220	225	228	finally
  }
  
  public void insertUnReadMessage(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.mUnReadNum += 1;
        this.mUnReadUinList.add(paramString);
        QLog.d("QCircleChatBoxHelper", 1, "insertUnReadMessage uin:" + paramString + "  allUnReadNum:" + this.mUnReadNum);
        this.mUnReadInfo = new Pair(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
        restoreUnReadInfo(this.mUnReadNum, this.mUnReadUinList);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleChatBoxHelper
 * JD-Core Version:    0.7.0.1
 */