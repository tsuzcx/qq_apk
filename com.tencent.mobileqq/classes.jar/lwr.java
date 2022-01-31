import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lwr
{
  public int a;
  public Vibrator a;
  public AVRedPacketManager a;
  public List<AVRedPacketManager.LocalEmojiInfo> a;
  public lwx a;
  public lwz a;
  public lxb a;
  public lxd a;
  public lxe a;
  public lxf a;
  public lxj a;
  public lxq a;
  public lxr a;
  public lxt a;
  public boolean a;
  public lxt[] a;
  public int b;
  private boolean b;
  public lxt[] b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public lwr(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfLxt = new lxt[10];
    this.jdField_b_of_type_ArrayOfLxt = new lxt[4];
    this.jdField_a_of_type_Lwz = new lwz();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lxe = new lxe(this.jdField_a_of_type_Lwz);
    this.jdField_a_of_type_Lxb = new lxb();
    this.jdField_a_of_type_Lxf = new lxf(this.jdField_a_of_type_Lxb);
    this.jdField_a_of_type_Lxq = new lxq();
    this.jdField_a_of_type_Lxr = new lxr();
    this.jdField_a_of_type_Lwx = new lwx(this.jdField_a_of_type_Lxb);
    this.jdField_a_of_type_Lxd = new lxd();
    this.jdField_a_of_type_Lxj = new lxj(this.jdField_a_of_type_Lxb);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Lwz.a(paramContext.getString(2131696269));
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localLocalEmojiInfo != null) {
        return localLocalEmojiInfo.emojiType;
      }
    }
    return -1;
  }
  
  public long a(AVRedPacketManager.LocalEmojiInfo paramLocalEmojiInfo)
  {
    long l2 = 3000L;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d())) {
      l1 = 5000L;
    }
    do
    {
      do
      {
        return l1;
        l1 = l2;
      } while (paramLocalEmojiInfo == null);
      if (paramLocalEmojiInfo.fallDownDuration > 0) {
        return paramLocalEmojiInfo.fallDownDuration;
      }
      l1 = l2;
    } while (paramLocalEmojiInfo.emojiId < 3);
    return 2000L;
  }
  
  public void a()
  {
    int j = 0;
    lxt[] arrayOflxt = this.jdField_a_of_type_ArrayOfLxt;
    int k = arrayOflxt.length;
    int i = 0;
    lxt locallxt;
    while (i < k)
    {
      locallxt = arrayOflxt[i];
      if (locallxt != null) {
        locallxt.a();
      }
      i += 1;
    }
    arrayOflxt = this.jdField_b_of_type_ArrayOfLxt;
    k = arrayOflxt.length;
    i = j;
    while (i < k)
    {
      locallxt = arrayOflxt[i];
      if (locallxt != null) {
        locallxt.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Lxt != null) {
      this.jdField_a_of_type_Lxt.a();
    }
    if (this.jdField_a_of_type_Lxe != null) {
      this.jdField_a_of_type_Lxe.b();
    }
    if (this.jdField_a_of_type_Lxf != null) {
      this.jdField_a_of_type_Lxf.b();
    }
    if (this.jdField_a_of_type_Lwx != null) {
      this.jdField_a_of_type_Lwx.b();
    }
    if (this.jdField_a_of_type_Lxd != null) {
      this.jdField_a_of_type_Lxd.b();
    }
    if (this.jdField_a_of_type_AndroidOsVibrator != null) {
      this.jdField_a_of_type_AndroidOsVibrator.cancel();
    }
    if (this.jdField_a_of_type_Lxj != null) {
      this.jdField_a_of_type_Lxj.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "recycle mAVRedPacketManager set to null");
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = null;
    this.jdField_a_of_type_ArrayOfLxt = null;
    this.jdField_b_of_type_ArrayOfLxt = null;
    this.jdField_a_of_type_Lxt = null;
    this.jdField_a_of_type_Lwz = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Lxe = null;
    this.jdField_a_of_type_Lxb = null;
    this.jdField_a_of_type_Lxf = null;
    this.jdField_a_of_type_Lxq = null;
    this.jdField_a_of_type_Lxr = null;
    this.jdField_a_of_type_Lwx = null;
    this.jdField_a_of_type_Lxd = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_Lxj = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 3;
    if (paramInt1 == 1) {
      paramInt1 = i;
    }
    for (;;)
    {
      if ((paramInt1 != -1) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramInt1, false);
      }
      if ((paramInt2 > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(6, false);
      }
      return;
      if (paramInt1 == 2) {
        paramInt1 = 2;
      } else if (paramInt1 == 3) {
        paramInt1 = 4;
      } else if (paramInt1 == 4) {
        paramInt1 = 5;
      } else {
        paramInt1 = -1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = (paramInt1 * 40 / 750);
    this.d = (paramInt1 * 600 / 750);
    this.e = (paramInt1 * 534 / 750);
    this.f = (paramInt1 * 260 / 750);
    this.jdField_a_of_type_Lwz.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxe.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxb.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxf.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxr.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxq.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lwx.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxd.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxj.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_Int = 0;
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Lwz.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Lwz.b(a(localLocalEmojiInfo));
      int i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_Lwz.b(i);
      this.jdField_a_of_type_Lwz.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxa = new lws(this);
      this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt = this.jdField_a_of_type_ArrayOfLxt[localLocalEmojiInfo.emojiType];
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lwz.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, 0L);
      }
      this.jdField_a_of_type_Lxe.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Lxe.a(localLocalEmojiInfo.isBigEmoji);
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    this.jdField_a_of_type_Lwz.a(paramCanvas, paramPaint);
    this.jdField_a_of_type_Lxe.a(paramCanvas, paramPaint);
    int k;
    int m;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      Rect localRect = this.jdField_a_of_type_Lxb.a();
      k = localRect.left;
      m = localRect.top;
      if (!loj.a()) {
        break label155;
      }
      j = this.c;
    }
    for (int i = this.d;; i = this.f)
    {
      paramCanvas.translate(j - k, i - m);
      this.jdField_a_of_type_Lxf.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lxb.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lxj.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lwx.a(paramCanvas, paramPaint);
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.restore();
      }
      this.jdField_a_of_type_Lxr.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lxd.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lxq.a(paramCanvas, paramPaint);
      return;
      label155:
      j = this.e;
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "setAVRedPacketManager1 avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = paramAVRedPacketManager;
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager, lxt[] paramArrayOflxt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLxt.length)
    {
      this.jdField_a_of_type_ArrayOfLxt[i] = new lxt(paramAVRedPacketManager.a("qav_redpacket_emoji_" + (i + 1) + ".png"));
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfLxt[0] = new lxt(paramAVRedPacketManager.a("qav_redpacket_perfect.png"));
    this.jdField_b_of_type_ArrayOfLxt[1] = new lxt(paramAVRedPacketManager.a("qav_redpacket_cool.png"));
    this.jdField_b_of_type_ArrayOfLxt[2] = new lxt(paramAVRedPacketManager.a("qav_redpacket_miss.png"));
    this.jdField_b_of_type_ArrayOfLxt[3] = new lxt(paramAVRedPacketManager.a("qav_redpacket_excellent.png"));
    this.jdField_a_of_type_Lxt = new lxt(paramAVRedPacketManager.a("qav_redpacket_miss_background.png"));
    this.jdField_a_of_type_Lwx.a(paramAVRedPacketManager, paramArrayOflxt);
    this.jdField_a_of_type_Lxd.a(paramAVRedPacketManager);
  }
  
  public void a(List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 0)) {
      break label21;
    }
    label21:
    while ((paramBoolean) && (this.jdField_b_of_type_Int == paramLocalFrameSyncInfo.localHitInfo.emojiId)) {
      return;
    }
    if (this.jdField_b_of_type_Int != paramLocalFrameSyncInfo.localHitInfo.emojiId)
    {
      this.jdField_b_of_type_Int = paramLocalFrameSyncInfo.localHitInfo.emojiId;
      this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    }
    if (paramBoolean) {
      a(paramLocalFrameSyncInfo.localHitInfo.topWordTipType, paramLocalFrameSyncInfo.localHitInfo.comboCnt);
    }
    long l;
    label105:
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    if (paramBoolean)
    {
      l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLocalFrameSyncInfo.localEmojiInfos.size() <= 0) {
        break label413;
      }
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0);
    }
    for (;;)
    {
      label132:
      this.jdField_a_of_type_Lxb.jdField_a_of_type_Long = l;
      Rect localRect = this.jdField_a_of_type_Lwz.a();
      this.jdField_a_of_type_Lxb.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.jdField_a_of_type_Lxf.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lxf.c();
      this.jdField_a_of_type_Lxr.jdField_a_of_type_Lxt = null;
      this.jdField_a_of_type_Lxr.b(-12375);
      this.jdField_a_of_type_Lwx.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lwx.c();
      this.jdField_a_of_type_Lwx.a(paramLocalFrameSyncInfo.localHitInfo.comboCnt, paramLocalFrameSyncInfo.localHitInfo.newAddScore);
      this.jdField_a_of_type_Lxj.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lxj.c();
      if ((localLocalEmojiInfo != null) && (localLocalEmojiInfo.emojiId == paramLocalFrameSyncInfo.localHitInfo.emojiId))
      {
        this.jdField_a_of_type_Lxb.jdField_a_of_type_Lxt = this.jdField_a_of_type_ArrayOfLxt[localLocalEmojiInfo.emojiType];
        this.jdField_a_of_type_Lxb.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lwx.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lxf.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lxq.a(localLocalEmojiInfo.isBigEmoji);
      }
      for (;;)
      {
        this.jdField_a_of_type_Lxr.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Lxq.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Lxq.jdField_a_of_type_Lxt = this.jdField_b_of_type_ArrayOfLxt[(paramLocalFrameSyncInfo.localHitInfo.topWordTipType - 1)];
        if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 4) {
          break;
        }
        this.jdField_a_of_type_Lxd.jdField_a_of_type_Long = l;
        return;
        l = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
        break label105;
        label413:
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label473;
        }
        localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(paramLocalFrameSyncInfo.localHitInfo.emojiId);
        break label132;
        this.jdField_a_of_type_Lxb.jdField_a_of_type_Lxt = this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt;
      }
      label473:
      localLocalEmojiInfo = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Lwz.a(true);
  }
  
  public void b(long paramLong)
  {
    long l1 = paramLong - this.jdField_a_of_type_Lwz.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Boolean) {
      if ((l1 > this.jdField_a_of_type_Lwz.a()) && (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Lxr.jdField_a_of_type_Lxt = this.jdField_a_of_type_Lxt;
        this.jdField_a_of_type_Lxr.b(-9942110);
        l1 = this.jdField_a_of_type_Lwz.jdField_a_of_type_Long + this.jdField_a_of_type_Lwz.a();
        if (this.jdField_a_of_type_Lxr.jdField_a_of_type_Long != l1)
        {
          this.jdField_a_of_type_Lxr.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_Lxq.jdField_a_of_type_Long = l1;
          a(3, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameEmojiAnimation", 2, "send show miss mCurEmojiItemId = " + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Lxq.jdField_a_of_type_Lxt = this.jdField_b_of_type_ArrayOfLxt[2];
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Lwz.a(paramLong);
      this.jdField_a_of_type_Lxe.a(paramLong);
      this.jdField_a_of_type_Lxb.a(paramLong);
      this.jdField_a_of_type_Lxf.a(paramLong);
      this.jdField_a_of_type_Lxr.a(paramLong);
      this.jdField_a_of_type_Lxq.a(paramLong);
      this.jdField_a_of_type_Lwx.a(paramLong);
      this.jdField_a_of_type_Lxd.a(paramLong);
      this.jdField_a_of_type_Lxj.a(paramLong);
      return;
      if ((l1 > this.jdField_a_of_type_Lwz.a()) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Lxr.jdField_a_of_type_Lxt = this.jdField_a_of_type_Lxt;
          this.jdField_a_of_type_Lxr.b(-9942110);
          this.jdField_a_of_type_Lxr.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lxq.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lxq.jdField_a_of_type_Lxt = this.jdField_b_of_type_ArrayOfLxt[2];
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_Lwz.a(false);
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          lwz locallwz = this.jdField_a_of_type_Lwz;
          locallwz.jdField_a_of_type_Long += this.jdField_a_of_type_Lwz.a() + 500L;
          this.jdField_a_of_type_Lwz.b(a(localLocalEmojiInfo));
          int i = this.jdField_a_of_type_Int % 3;
          this.jdField_a_of_type_Lwz.b(i);
          this.jdField_a_of_type_Lwz.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt = this.jdField_a_of_type_ArrayOfLxt[localLocalEmojiInfo.emojiType];
          this.jdField_a_of_type_Lxe.a(localLocalEmojiInfo.isBigEmoji);
          long l2 = this.jdField_a_of_type_Lwz.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lwz.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
          }
        }
        else if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Lxr.jdField_a_of_type_Lxt = this.jdField_a_of_type_Lxt;
          this.jdField_a_of_type_Lxr.b(-9942110);
          this.jdField_a_of_type_Lxr.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lxq.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lxq.jdField_a_of_type_Lxt = this.jdField_b_of_type_ArrayOfLxt[2];
          this.jdField_a_of_type_Int += 1;
        }
      }
    }
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_a_of_type_Lxe.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lxf.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lxj.a(paramAVRedPacketManager);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    long l1 = 0L;
    a(paramBoolean, paramLocalFrameSyncInfo);
    if (paramBoolean)
    {
      if (paramLocalFrameSyncInfo.localEmojiInfos.size() > 0)
      {
        paramLocalFrameSyncInfo = (AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0);
        QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + paramLocalFrameSyncInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
        if (this.jdField_a_of_type_Int != paramLocalFrameSyncInfo.emojiId)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState,new emoji, isSend = " + paramBoolean + ", localEmojiInfo = " + paramLocalFrameSyncInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
          }
          this.jdField_a_of_type_Int = paramLocalFrameSyncInfo.emojiId;
          this.jdField_a_of_type_Lwz.b(a(paramLocalFrameSyncInfo));
          this.jdField_a_of_type_Lwz.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_Lwz.b(paramLocalFrameSyncInfo.trackNum);
          this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt = this.jdField_a_of_type_ArrayOfLxt[paramLocalFrameSyncInfo.emojiType];
          this.jdField_a_of_type_Lxe.a(paramLocalFrameSyncInfo.isBigEmoji);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramLocalFrameSyncInfo.emojiId, paramLocalFrameSyncInfo.emojiType);
          }
        }
      }
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt = null;
      }
    }
    while ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Lwz.a(false);
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    int i;
    long l2;
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + localLocalEmojiInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_Lwz.jdField_a_of_type_Long = (paramLocalFrameSyncInfo.localHitInfo.hitStartTime + 500L);
      this.jdField_a_of_type_Lwz.b(a(localLocalEmojiInfo));
      i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_Lwz.b(i);
      this.jdField_a_of_type_Lwz.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt = this.jdField_a_of_type_ArrayOfLxt[localLocalEmojiInfo.emojiType];
      l2 = this.jdField_a_of_type_Lwz.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
      if (l2 >= 0L) {
        break label577;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lwz.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
      }
      this.jdField_a_of_type_Lxe.a(localLocalEmojiInfo.isBigEmoji);
      return;
      this.jdField_a_of_type_Lwz.jdField_a_of_type_Lxt = null;
      return;
      label577:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lwr
 * JD-Core Version:    0.7.0.1
 */