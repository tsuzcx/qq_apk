import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavDef.MultiUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class noc
  extends bjua
  implements lfs
{
  private nob jdField_a_of_type_Nob;
  private mow[] jdField_a_of_type_ArrayOfMow;
  
  public noc(Context paramContext, long paramLong, bjtt parambjtt)
  {
    super(paramContext, paramLong, parambjtt);
  }
  
  public int a(bjto parambjto)
  {
    try
    {
      int i = super.a(parambjto);
      if (i == 0) {
        nob.a();
      }
      return i;
    }
    finally {}
  }
  
  public void a()
  {
    bjuc.c("MultiOperatorImplForGame", "startAudioRecv mHasCallExitRoom：=" + this.b);
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
    bjul.a().a(bjub.class, 13, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
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
      bjul.a().a(bjub.class, 11, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void a(int paramInt, mow parammow)
  {
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMow == null) {
      this.jdField_a_of_type_ArrayOfMow = new mow[2];
    }
    try
    {
      this.jdField_a_of_type_ArrayOfMow[paramInt] = parammow;
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    bjuc.c("MultiOperatorImplForGame", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(paramBoolean) }));
    if (paramInt == 2) {
      bjul.a().a(bjub.class, 16, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    QavDef.MultiUserInfo localMultiUserInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      bjuc.c("MultiOperatorImplForGame", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
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
      bjuc.d("MultiOperatorImplForGame", "onMultiVideoChatMembersInfoChange, error. type[" + paramInt1 + "], id[" + paramLong1 + "], type[" + paramInt2 + "], user[" + l + "]");
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
        bjul.a().a(bjub.class, 6, new Object[] { paramArrayOfLong, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
        return;
      }
    case 72: 
      bjul.a().a(bjub.class, 9, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    bjul.a().a(bjub.class, 10, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
  }
  
  public void a(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bjto == null) {}
    label163:
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          bjuc.c("MultiOperatorImplForGame", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
          if (paramAVUserInfo.account == this.jdField_a_of_type_Long)
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              i();
              bjul.a().a(bjub.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramAVUserInfo.account);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break label163;
            }
            paramAVUserInfo = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramAVUserInfo = new QavDef.MultiUserInfo();
              paramAVUserInfo.mUin = this.jdField_a_of_type_Bjto.jdField_a_of_type_Long;
              paramAVUserInfo.mOpenId = this.jdField_a_of_type_Bjto.jdField_a_of_type_JavaLangString;
              paramAVUserInfo.mMicOn = true;
              a(paramAVUserInfo);
            }
          }
          for (;;)
          {
            b(paramAVUserInfo);
            return;
            paramInt1 = 0;
            break;
            paramVarArgs = new QavDef.MultiUserInfo();
            paramVarArgs.mUin = paramAVUserInfo.account;
            paramVarArgs.mMicOn = true;
            a(paramVarArgs);
            paramAVUserInfo = paramVarArgs;
          }
        }
      } while (paramInt1 != 71);
      bjuc.c("MultiOperatorImplForGame", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      paramAVUserInfo = b(paramAVUserInfo.account);
    } while (paramAVUserInfo == null);
    c(paramAVUserInfo);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 100) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfMow != null) && (this.jdField_a_of_type_ArrayOfMow[0] != null)) {
          this.jdField_a_of_type_ArrayOfMow[0].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
    if ((paramInt4 == 3) || (paramInt4 == 0) || (paramInt4 == 1) || (paramInt4 == 2) || (paramInt4 == 8)) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfMow != null) && (this.jdField_a_of_type_ArrayOfMow[1] != null)) {
          this.jdField_a_of_type_ArrayOfMow[1].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    bjuc.c("MultiOperatorImplForGame", "goOnStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();; i = 0)
    {
      bjuc.d("MultiOperatorImplForGame", "goOnStage, ret[" + i + "]");
      if (i == 0) {
        break;
      }
      return true;
    }
  }
  
  public void b()
  {
    bjuc.c("MultiOperatorImplForGame", "stopAudioRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    bjul.a().a(bjub.class, 13, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 93) {}
    for (boolean bool = true;; bool = false)
    {
      bjul.a().a(bjub.class, 12, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  public boolean b()
  {
    bjuc.c("MultiOperatorImplForGame", "goOffStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();; i = -1)
    {
      bjuc.d("MultiOperatorImplForGame", "goOffStage, ret[" + i + "]");
      if (i != -1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void c()
  {
    bjuc.c("MultiOperatorImplForGame", "startAVGameVideoRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    nof localnof;
    do
    {
      do
      {
        return;
        localnof = nnm.b().a();
      } while (localnof == null);
      boolean bool = SecurityPolicyChecker.a().b();
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localnof.a.clear();
      Object localObject = new ArrayList(8);
      localnof.c((List)localObject);
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
              localnof.a.add(locallob);
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
              localnof.a.add(locallob);
            }
            if (localAVGameUserInfo.mSubVideoOn)
            {
              locallob = new lob();
              locallob.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              locallob.jdField_a_of_type_Int = localAVGameUserInfo.mSubVideoSrc;
              locallob.jdField_a_of_type_Boolean = false;
              localnof.a.add(locallob);
            }
          }
        }
      }
      if (localnof.a.isEmpty())
      {
        bjuc.a("MultiOperatorImplForGame", "startAVGameVideoRecv fail with empty uinList");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAVGameVideoRecv(localnof.a);
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    bjul.a().a(bjub.class, 15, new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void d()
  {
    bjuc.c("MultiOperatorImplForGame", "stopAVGameVideoRecv mHasCallExitRoom：=" + this.b);
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
    //   2: ldc 24
    //   4: ldc_w 324
    //   7: invokestatic 51	bjuc:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 150	noc:jdField_a_of_type_Bjto	Lbjto;
    //   15: aload_0
    //   16: getfield 327	noc:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 327	noc:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   26: invokeinterface 330 1 0
    //   31: iconst_m1
    //   32: istore_1
    //   33: invokestatic 334	ngk:b	()V
    //   36: getstatic 339	android/os/Build$VERSION:SDK_INT	I
    //   39: bipush 16
    //   41: if_icmplt +6 -> 47
    //   44: invokestatic 342	lfm:a	()V
    //   47: aload_0
    //   48: getfield 54	noc:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   51: ifnull +75 -> 126
    //   54: invokestatic 344	nob:a	()Z
    //   57: ifeq +79 -> 136
    //   60: aload_0
    //   61: getfield 346	noc:jdField_a_of_type_Nob	Lnob;
    //   64: ifnonnull +14 -> 78
    //   67: aload_0
    //   68: new 19	nob
    //   71: dup
    //   72: invokespecial 347	nob:<init>	()V
    //   75: putfield 346	noc:jdField_a_of_type_Nob	Lnob;
    //   78: aload_0
    //   79: getfield 346	noc:jdField_a_of_type_Nob	Lnob;
    //   82: aload_0
    //   83: invokevirtual 350	noc:a	()Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   86: invokevirtual 353	nob:a	(Lcom/tencent/av/gaudio/QQGAudioCtrl;)I
    //   89: istore_1
    //   90: aload_0
    //   91: invokevirtual 163	noc:i	()V
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 106	noc:jdField_a_of_type_Boolean	Z
    //   99: aload_0
    //   100: iconst_1
    //   101: putfield 38	noc:b	Z
    //   104: iload_1
    //   105: sipush 261
    //   108: if_icmpne +18 -> 126
    //   111: invokestatic 235	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   114: invokevirtual 239	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   117: checkcast 355	com/tencent/avgame/app/AVGameAppInterface
    //   120: sipush 1006
    //   123: invokevirtual 357	com/tencent/avgame/app/AVGameAppInterface:b	(I)V
    //   126: invokestatic 362	nqc:a	()Lnqc;
    //   129: iconst_1
    //   130: invokevirtual 364	nqc:a	(I)V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: aload_0
    //   137: getfield 54	noc:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   140: iconst_0
    //   141: invokevirtual 368	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   144: pop
    //   145: goto -55 -> 90
    //   148: astore_2
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	noc
    //   32	77	1	i	int
    //   148	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	148	finally
    //   33	47	148	finally
    //   47	78	148	finally
    //   78	90	148	finally
    //   90	104	148	finally
    //   111	126	148	finally
    //   126	133	148	finally
    //   136	145	148	finally
  }
  
  public void e(long paramLong)
  {
    bjul.a().a(bjub.class, 8, new Object[] { Integer.valueOf((int)paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     noc
 * JD-Core Version:    0.7.0.1
 */