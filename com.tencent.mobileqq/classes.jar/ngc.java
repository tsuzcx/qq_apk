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

public class ngc
  extends bkdn
{
  private ngb jdField_a_of_type_Ngb;
  private moq[] jdField_a_of_type_ArrayOfMoq;
  
  public ngc(Context paramContext, long paramLong, bkdh parambkdh)
  {
    super(paramContext, paramLong, parambkdh);
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
  
  public int a(bkdc parambkdc)
  {
    try
    {
      int i = super.a(parambkdc);
      if (i == 0) {
        ngb.a();
      }
      return i;
    }
    finally {}
  }
  
  public void a()
  {
    bkdp.c("MultiOperatorImplForGame", "startAudioRecv mHasCallExitRoom：=" + this.b);
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
    bkdy.a().a(bkdo.class, 13, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
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
      bkdy.a().a(bkdo.class, 11, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void a(int paramInt, moq parammoq)
  {
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMoq == null) {
      this.jdField_a_of_type_ArrayOfMoq = new moq[2];
    }
    try
    {
      this.jdField_a_of_type_ArrayOfMoq[paramInt] = parammoq;
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
      bkdp.c("MultiOperatorImplForGame", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
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
      bkdp.d("MultiOperatorImplForGame", "onMultiVideoChatMembersInfoChange, error. type[" + paramInt1 + "], id[" + paramLong1 + "], type[" + paramInt2 + "], user[" + l + "]");
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
        bkdy.a().a(bkdo.class, 6, new Object[] { paramArrayOfLong, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
        return;
      }
    case 72: 
      bkdy.a().a(bkdo.class, 9, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    bkdy.a().a(bkdo.class, 10, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
  }
  
  protected void a(VideoConstants.ThirdCallType paramThirdCallType, boolean paramBoolean)
  {
    bkdp.c("MultiOperatorImplForGame", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", new Object[] { paramThirdCallType, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(paramBoolean) }));
    if (paramThirdCallType == VideoConstants.ThirdCallType.SYSTEM_CALL) {
      bkdy.a().a(bkdo.class, 16, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void a(lnd paramlnd, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bkdc == null) {}
    label163:
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bkdp.c("MultiOperatorImplForGame", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramlnd.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
          if (paramlnd.jdField_a_of_type_Long == this.jdField_a_of_type_Long)
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              i();
              bkdy.a().a(bkdo.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramlnd.jdField_a_of_type_Long);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break label163;
            }
            paramlnd = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramlnd = new QavDef.MultiUserInfo();
              paramlnd.mUin = this.jdField_a_of_type_Bkdc.jdField_a_of_type_Long;
              paramlnd.mOpenId = this.jdField_a_of_type_Bkdc.jdField_a_of_type_JavaLangString;
              paramlnd.mMicOn = true;
              a(paramlnd);
            }
          }
          for (;;)
          {
            b(paramlnd);
            return;
            paramInt1 = 0;
            break;
            paramVarArgs = new QavDef.MultiUserInfo();
            paramVarArgs.mUin = paramlnd.jdField_a_of_type_Long;
            paramVarArgs.mMicOn = true;
            a(paramVarArgs);
            paramlnd = paramVarArgs;
          }
        }
      } while (paramInt1 != 71);
      bkdp.c("MultiOperatorImplForGame", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramlnd.jdField_a_of_type_Long), Long.valueOf(paramLong1) }));
      paramlnd = b(paramlnd.jdField_a_of_type_Long);
    } while (paramlnd == null);
    c(paramlnd);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 100) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfMoq != null) && (this.jdField_a_of_type_ArrayOfMoq[0] != null)) {
          this.jdField_a_of_type_ArrayOfMoq[0].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
    if ((paramInt4 == 3) || (paramInt4 == 0) || (paramInt4 == 1) || (paramInt4 == 2)) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfMoq != null) && (this.jdField_a_of_type_ArrayOfMoq[1] != null)) {
          this.jdField_a_of_type_ArrayOfMoq[1].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    bkdp.c("MultiOperatorImplForGame", "goOnStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();; i = 0)
    {
      bkdp.d("MultiOperatorImplForGame", "goOnStage, ret[" + i + "]");
      if (i == 0) {
        break;
      }
      return true;
    }
  }
  
  public void b()
  {
    bkdp.c("MultiOperatorImplForGame", "stopAudioRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    bkdy.a().a(bkdo.class, 13, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 93) {}
    for (boolean bool = true;; bool = false)
    {
      bkdy.a().a(bkdo.class, 12, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  public boolean b()
  {
    bkdp.c("MultiOperatorImplForGame", "goOffStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();; i = -1)
    {
      bkdp.d("MultiOperatorImplForGame", "goOffStage, ret[" + i + "]");
      if (i != -1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void c()
  {
    bkdp.c("MultiOperatorImplForGame", "startAVGameVideoRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    AVGameSession localAVGameSession;
    do
    {
      do
      {
        return;
        localAVGameSession = nfm.b().a();
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
          lob locallob;
          if (bool)
          {
            if ((localAVGameUserInfo.mVideoOn) && (localAVGameUserInfo.mBigVideo))
            {
              locallob = new lob();
              locallob.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallob.jdField_a_of_type_Int = localAVGameUserInfo.mVideoSrc;
              locallob.jdField_a_of_type_Boolean = localAVGameUserInfo.mBigVideo;
              localAVGameSession.a.add(locallob);
            }
          }
          else
          {
            if (localAVGameUserInfo.mVideoOn)
            {
              locallob = new lob();
              locallob.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallob.jdField_a_of_type_Int = localAVGameUserInfo.mVideoSrc;
              locallob.jdField_a_of_type_Boolean = localAVGameUserInfo.mBigVideo;
              localAVGameSession.a.add(locallob);
            }
            if (localAVGameUserInfo.mSubVideoOn)
            {
              locallob = new lob();
              locallob.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallob.jdField_a_of_type_Int = localAVGameUserInfo.mSubVideoSrc;
              locallob.jdField_a_of_type_Boolean = false;
              localAVGameSession.a.add(locallob);
            }
          }
        }
      }
      if (localAVGameSession.a.isEmpty())
      {
        bkdp.a("MultiOperatorImplForGame", "startAVGameVideoRecv fail with empty uinList");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAVGameVideoRecv(localAVGameSession.a);
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    bkdy.a().a(bkdo.class, 15, new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void d()
  {
    bkdp.c("MultiOperatorImplForGame", "stopAVGameVideoRecv mHasCallExitRoom：=" + this.b);
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
    //   7: invokestatic 66	bkdp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 166	ngc:jdField_a_of_type_Bkdc	Lbkdc;
    //   15: aload_0
    //   16: getfield 341	ngc:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 341	ngc:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   26: invokeinterface 344 1 0
    //   31: iconst_m1
    //   32: istore_1
    //   33: invokestatic 348	mzt:b	()V
    //   36: aload_0
    //   37: getfield 16	ngc:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   40: ifnull +75 -> 115
    //   43: invokestatic 350	ngb:a	()Z
    //   46: ifeq +79 -> 125
    //   49: aload_0
    //   50: getfield 352	ngc:jdField_a_of_type_Ngb	Lngb;
    //   53: ifnonnull +14 -> 67
    //   56: aload_0
    //   57: new 34	ngb
    //   60: dup
    //   61: invokespecial 353	ngb:<init>	()V
    //   64: putfield 352	ngc:jdField_a_of_type_Ngb	Lngb;
    //   67: aload_0
    //   68: getfield 352	ngc:jdField_a_of_type_Ngb	Lngb;
    //   71: aload_0
    //   72: invokevirtual 356	ngc:a	()Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   75: invokevirtual 359	ngb:a	(Lcom/tencent/av/gaudio/QQGAudioCtrl;)I
    //   78: istore_1
    //   79: aload_0
    //   80: invokevirtual 177	ngc:i	()V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 156	ngc:jdField_a_of_type_Boolean	Z
    //   88: aload_0
    //   89: iconst_1
    //   90: putfield 53	ngc:b	Z
    //   93: iload_1
    //   94: sipush 261
    //   97: if_icmpne +18 -> 115
    //   100: invokestatic 249	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   103: invokevirtual 253	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   106: checkcast 361	com/tencent/avgame/app/AVGameAppInterface
    //   109: sipush 1006
    //   112: invokevirtual 363	com/tencent/avgame/app/AVGameAppInterface:b	(I)V
    //   115: invokestatic 368	nhp:a	()Lnhp;
    //   118: iconst_1
    //   119: invokevirtual 370	nhp:a	(I)V
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: aload_0
    //   126: getfield 16	ngc:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   129: iconst_0
    //   130: invokevirtual 373	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   133: pop
    //   134: goto -55 -> 79
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	ngc
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
    bkdy.a().a(bkdo.class, 8, new Object[] { Integer.valueOf((int)paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngc
 * JD-Core Version:    0.7.0.1
 */