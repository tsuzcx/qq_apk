package com.tencent.mobileqq.qcircle.api.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qroute.QRoute;
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
    paramList = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
    if (paramList != null)
    {
      paramList.edit().putString("qcircle_unread_message_info", localStringBuilder.toString()).apply();
      RFLog.d("QCircleChatBoxHelper", RFLog.USR, "restoreUnReadInfo unReadNum:" + paramInt);
    }
  }
  
  public void clearUnReadInfo()
  {
    try
    {
      RFLog.d("QCircleChatBoxHelper", RFLog.USR, "clearUnReadInfo");
      this.mUnReadNum = 0;
      this.mUnReadUinList = new LinkedList();
      this.mUnReadInfo = new Pair(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
      restoreUnReadInfo(0, this.mUnReadUinList);
      SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent("QCircleChatBoxHelper clearUnReadInfo", true));
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
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   6: ifnull +45 -> 51
    //   9: ldc 11
    //   11: getstatic 104	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   14: new 40	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   21: ldc 153
    //   23: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   30: getfield 157	android/util/Pair:first	Ljava/lang/Object;
    //   33: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 110	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: areturn
    //   51: aload_0
    //   52: new 118	android/util/Pair
    //   55: dup
    //   56: iconst_0
    //   57: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: new 27	java/util/LinkedList
    //   63: dup
    //   64: invokespecial 28	java/util/LinkedList:<init>	()V
    //   67: invokespecial 127	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   70: putfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   73: ldc 68
    //   75: invokestatic 74	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   78: checkcast 68	com/tencent/mobileqq/qcircle/api/IQCircleConfigApi
    //   81: invokeinterface 78 1 0
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +148 -> 236
    //   91: aload_2
    //   92: ldc 86
    //   94: ldc 162
    //   96: invokeinterface 166 3 0
    //   101: astore_2
    //   102: aload_2
    //   103: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +130 -> 236
    //   109: aload_2
    //   110: ldc 8
    //   112: invokevirtual 176	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   115: astore_2
    //   116: aload_2
    //   117: arraylength
    //   118: iconst_1
    //   119: if_icmple +41 -> 160
    //   122: aload_0
    //   123: aload_2
    //   124: iconst_0
    //   125: aaload
    //   126: invokestatic 180	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   129: putfield 116	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadNum	I
    //   132: iconst_1
    //   133: istore_1
    //   134: iload_1
    //   135: aload_2
    //   136: arraylength
    //   137: if_icmpge +23 -> 160
    //   140: aload_0
    //   141: getfield 30	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadUinList	Ljava/util/List;
    //   144: aload_2
    //   145: iload_1
    //   146: aaload
    //   147: invokeinterface 184 2 0
    //   152: pop
    //   153: iload_1
    //   154: iconst_1
    //   155: iadd
    //   156: istore_1
    //   157: goto -23 -> 134
    //   160: ldc 11
    //   162: getstatic 104	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   165: new 40	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   172: ldc 186
    //   174: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   181: getfield 157	android/util/Pair:first	Ljava/lang/Object;
    //   184: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 110	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_0
    //   194: new 118	android/util/Pair
    //   197: dup
    //   198: aload_0
    //   199: getfield 116	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadNum	I
    //   202: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aload_0
    //   206: getfield 30	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadUinList	Ljava/util/List;
    //   209: invokespecial 127	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   212: putfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   215: aload_0
    //   216: getfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   219: astore_2
    //   220: goto -173 -> 47
    //   223: astore_2
    //   224: ldc 11
    //   226: getstatic 104	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   229: aload_2
    //   230: invokevirtual 189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokestatic 192	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_0
    //   237: getfield 129	com/tencent/mobileqq/qcircle/api/helper/QCircleChatBoxHelper:mUnReadInfo	Landroid/util/Pair;
    //   240: astore_2
    //   241: goto -194 -> 47
    //   244: astore_2
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_2
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	QCircleChatBoxHelper
    //   133	24	1	i	int
    //   46	174	2	localObject1	Object
    //   223	7	2	localException	java.lang.Exception
    //   240	1	2	localPair	Pair
    //   244	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   73	87	223	java/lang/Exception
    //   91	132	223	java/lang/Exception
    //   134	153	223	java/lang/Exception
    //   160	220	223	java/lang/Exception
    //   2	47	244	finally
    //   51	73	244	finally
    //   73	87	244	finally
    //   91	132	244	finally
    //   134	153	244	finally
    //   160	220	244	finally
    //   224	236	244	finally
    //   236	241	244	finally
  }
  
  public void insertUnReadMessage(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.mUnReadNum += 1;
        this.mUnReadUinList.add(paramString);
        RFLog.d("QCircleChatBoxHelper", RFLog.USR, "insertUnReadMessage uin:" + paramString + "  allUnReadNum:" + this.mUnReadNum);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper
 * JD-Core Version:    0.7.0.1
 */