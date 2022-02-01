import android.content.Context;
import com.tencent.av.VideoConstants.ThirdCallType;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavDef.MultiUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class nej
  extends bjco
{
  private nei jdField_a_of_type_Nei;
  private mnt[] jdField_a_of_type_ArrayOfMnt;
  
  public nej(Context paramContext, long paramLong, bjci parambjci)
  {
    super(paramContext, paramLong, parambjci);
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.unregisterAudioDataCallback(paramInt);
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioDataFormat(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return -1;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.registerAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int a(bjcd parambjcd)
  {
    try
    {
      int i = super.a(parambjcd);
      if (i == 0) {
        nei.a();
      }
      return i;
    }
    finally {}
  }
  
  public void a()
  {
    bjcq.c("MultiOperatorImplForGame", "startAudioRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAECMode(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    bjcz.a().a(bjcp.class, 13, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    boolean bool;
    if (paramInt1 == 90) {
      if (paramLong1 == 3L) {
        bool = true;
      }
    }
    for (;;)
    {
      bjcz.a().a(bjcp.class, 11, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void a(int paramInt, mnt parammnt)
  {
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMnt == null) {
      this.jdField_a_of_type_ArrayOfMnt = new mnt[2];
    }
    try
    {
      this.jdField_a_of_type_ArrayOfMnt[paramInt] = parammnt;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    QavDef.MultiUserInfo localMultiUserInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      bjcq.c("MultiOperatorImplForGame", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localMultiUserInfo = a(paramLong);
      if (localMultiUserInfo != null) {
        if (paramBoolean) {
          break label83;
        }
      }
    }
    label83:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localMultiUserInfo.mMicOn = paramBoolean;
      a(localMultiUserInfo, bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return;
    }
    long l = paramArrayOfLong[0];
    switch (paramInt1)
    {
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    default: 
      bjcq.d("MultiOperatorImplForGame", "onMultiVideoChatMembersInfoChange, error. type[" + paramInt1 + "], id[" + paramLong1 + "], type[" + paramInt2 + "], user[" + l + "]");
      return;
    case 42: 
    case 43: 
      if (paramInt1 == 42) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfLong = a(l);
        if (paramArrayOfLong == null) {
          break;
        }
        bjcz.a().a(bjcp.class, 6, new Object[] { paramArrayOfLong, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
        return;
      }
    case 72: 
      bjcz.a().a(bjcp.class, 9, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    bjcz.a().a(bjcp.class, 10, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
  }
  
  protected void a(VideoConstants.ThirdCallType paramThirdCallType, boolean paramBoolean)
  {
    bjcq.c("MultiOperatorImplForGame", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", new Object[] { paramThirdCallType, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(paramBoolean) }));
    if (paramThirdCallType == VideoConstants.ThirdCallType.SYSTEM_CALL) {
      bjcz.a().a(bjcp.class, 16, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void a(lmp paramlmp, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bjcd == null) {}
    label163:
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bjcq.c("MultiOperatorImplForGame", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlmp.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlmp.jdField_a_of_type_Long == this.jdField_a_of_type_Long)
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              i();
              bjcz.a().a(bjcp.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlmp.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break label163;
            }
            paramlmp = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlmp = new QavDef.MultiUserInfo();
              paramlmp.mUin = this.jdField_a_of_type_Bjcd.jdField_a_of_type_Long;
              paramlmp.mOpenId = this.jdField_a_of_type_Bjcd.jdField_a_of_type_JavaLangString;
              paramlmp.mMicOn = true;
              a(paramlmp);
            }
          }
          for (;;)
          {
            b(paramlmp);
            return;
            paramInt1 = 0;
            break;
            paramVarArgs = new QavDef.MultiUserInfo();
            paramVarArgs.mUin = paramlmp.jdField_a_of_type_Long;
            paramVarArgs.mMicOn = true;
            a(paramVarArgs);
            paramlmp = paramVarArgs;
          }
        }
      } while (paramInt1 != 71);
      bjcq.c("MultiOperatorImplForGame", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlmp.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramlmp = b(paramlmp.jdField_a_of_type_Long);
    } while (paramlmp == null);
    c(paramlmp);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 100) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfMnt != null) && (this.jdField_a_of_type_ArrayOfMnt[0] != null)) {
          this.jdField_a_of_type_ArrayOfMnt[0].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
    if ((paramInt4 == 3) || (paramInt4 == 0) || (paramInt4 == 1)) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfMnt != null) && (this.jdField_a_of_type_ArrayOfMnt[1] != null)) {
          this.jdField_a_of_type_ArrayOfMnt[1].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    bjcq.c("MultiOperatorImplForGame", "goOnStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();; i = 0)
    {
      bjcq.d("MultiOperatorImplForGame", "goOnStage, ret[" + i + "]");
      if (i == 0) {
        break;
      }
      return true;
    }
  }
  
  public void b()
  {
    bjcq.c("MultiOperatorImplForGame", "stopAudioRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    bjcz.a().a(bjcp.class, 13, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 93) {}
    for (boolean bool = true;; bool = false)
    {
      bjcz.a().a(bjcp.class, 12, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  public boolean b()
  {
    bjcq.c("MultiOperatorImplForGame", "goOffStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();; i = -1)
    {
      bjcq.d("MultiOperatorImplForGame", "goOffStage, ret[" + i + "]");
      if (i != -1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void c()
  {
    bjcq.c("MultiOperatorImplForGame", "startAVGameVideoRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    AVGameSession localAVGameSession;
    do
    {
      do
      {
        return;
        localAVGameSession = ndt.b().a();
      } while (localAVGameSession == null);
      boolean bool = SecurityPolicyChecker.a().b();
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localAVGameSession.a.clear();
      Object localObject = new ArrayList(8);
      localAVGameSession.c((List)localObject);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AVGameUserInfo localAVGameUserInfo = (AVGameUserInfo)((Iterator)localObject).next();
        if (localAVGameUserInfo.mUin != l)
        {
          lnn locallnn;
          if (bool)
          {
            if ((localAVGameUserInfo.mVideoOn) && (localAVGameUserInfo.mBigVideo))
            {
              locallnn = new lnn();
              locallnn.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallnn.jdField_a_of_type_Int = localAVGameUserInfo.mVideoSrc;
              locallnn.jdField_a_of_type_Boolean = localAVGameUserInfo.mBigVideo;
              localAVGameSession.a.add(locallnn);
            }
          }
          else
          {
            if (localAVGameUserInfo.mVideoOn)
            {
              locallnn = new lnn();
              locallnn.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallnn.jdField_a_of_type_Int = localAVGameUserInfo.mVideoSrc;
              locallnn.jdField_a_of_type_Boolean = localAVGameUserInfo.mBigVideo;
              localAVGameSession.a.add(locallnn);
            }
            if (localAVGameUserInfo.mSubVideoOn)
            {
              locallnn = new lnn();
              locallnn.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallnn.jdField_a_of_type_Int = localAVGameUserInfo.mSubVideoSrc;
              locallnn.jdField_a_of_type_Boolean = false;
              localAVGameSession.a.add(locallnn);
            }
          }
        }
      }
      if (localAVGameSession.a.isEmpty())
      {
        bjcq.a("MultiOperatorImplForGame", "startAVGameVideoRecv fail with empty uinList");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAVGameVideoRecv(localAVGameSession.a);
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    bjcz.a().a(bjcp.class, 15, new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void d()
  {
    bjcq.c("MultiOperatorImplForGame", "stopAVGameVideoRecv mHasCallExitRoom：=" + this.b);
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && (!this.b)) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv();
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 39
    //   4: ldc_w 338
    //   7: invokestatic 66	bjcq:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 166	nej:jdField_a_of_type_Bjcd	Lbjcd;
    //   15: aload_0
    //   16: getfield 341	nej:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 341	nej:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   26: invokeinterface 344 1 0
    //   31: iconst_m1
    //   32: istore_1
    //   33: invokestatic 348	myq:b	()V
    //   36: aload_0
    //   37: getfield 16	nej:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   40: ifnull +75 -> 115
    //   43: invokestatic 350	nei:a	()Z
    //   46: ifeq +79 -> 125
    //   49: aload_0
    //   50: getfield 352	nej:jdField_a_of_type_Nei	Lnei;
    //   53: ifnonnull +14 -> 67
    //   56: aload_0
    //   57: new 34	nei
    //   60: dup
    //   61: invokespecial 353	nei:<init>	()V
    //   64: putfield 352	nej:jdField_a_of_type_Nei	Lnei;
    //   67: aload_0
    //   68: getfield 352	nej:jdField_a_of_type_Nei	Lnei;
    //   71: aload_0
    //   72: invokevirtual 356	nej:a	()Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   75: invokevirtual 359	nei:a	(Lcom/tencent/av/gaudio/QQGAudioCtrl;)I
    //   78: istore_1
    //   79: aload_0
    //   80: invokevirtual 177	nej:i	()V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 156	nej:jdField_a_of_type_Boolean	Z
    //   88: aload_0
    //   89: iconst_1
    //   90: putfield 53	nej:b	Z
    //   93: iload_1
    //   94: sipush 261
    //   97: if_icmpne +18 -> 115
    //   100: invokestatic 249	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   103: invokevirtual 253	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   106: checkcast 361	com/tencent/avgame/app/AVGameAppInterface
    //   109: sipush 1006
    //   112: invokevirtual 363	com/tencent/avgame/app/AVGameAppInterface:b	(I)V
    //   115: invokestatic 368	nfu:a	()Lnfu;
    //   118: iconst_1
    //   119: invokevirtual 370	nfu:a	(I)V
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: aload_0
    //   126: getfield 16	nej:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   129: iconst_0
    //   130: invokevirtual 373	com/tencent/av/gaudio/QQGAudioCtrl:quit	(I)I
    //   133: pop
    //   134: goto -55 -> 79
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	nej
    //   32	66	1	i	int
    //   137	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	137	finally
    //   33	67	137	finally
    //   67	79	137	finally
    //   79	93	137	finally
    //   100	115	137	finally
    //   115	122	137	finally
    //   125	134	137	finally
  }
  
  public void f(long paramLong)
  {
    bjcz.a().a(bjcp.class, 8, new Object[] { Integer.valueOf((int)paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nej
 * JD-Core Version:    0.7.0.1
 */