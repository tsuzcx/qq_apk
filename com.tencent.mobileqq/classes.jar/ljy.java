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

public class ljy
{
  public int a;
  public Vibrator a;
  public AVRedPacketManager a;
  public List<AVRedPacketManager.LocalEmojiInfo> a;
  public lke a;
  public lkg a;
  public lki a;
  public lkk a;
  public lkl a;
  public lkm a;
  public lkq a;
  public lkx a;
  public lky a;
  public lla a;
  public boolean a;
  public lla[] a;
  public int b;
  private boolean b;
  public lla[] b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public ljy(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfLla = new lla[10];
    this.jdField_b_of_type_ArrayOfLla = new lla[4];
    this.jdField_a_of_type_Lkg = new lkg();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lkl = new lkl(this.jdField_a_of_type_Lkg);
    this.jdField_a_of_type_Lki = new lki();
    this.jdField_a_of_type_Lkm = new lkm(this.jdField_a_of_type_Lki);
    this.jdField_a_of_type_Lkx = new lkx();
    this.jdField_a_of_type_Lky = new lky();
    this.jdField_a_of_type_Lke = new lke(this.jdField_a_of_type_Lki);
    this.jdField_a_of_type_Lkk = new lkk();
    this.jdField_a_of_type_Lkq = new lkq(this.jdField_a_of_type_Lki);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Lkg.a(paramContext.getString(2131630406));
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
    lla[] arrayOflla = this.jdField_a_of_type_ArrayOfLla;
    int k = arrayOflla.length;
    int i = 0;
    lla locallla;
    while (i < k)
    {
      locallla = arrayOflla[i];
      if (locallla != null) {
        locallla.a();
      }
      i += 1;
    }
    arrayOflla = this.jdField_b_of_type_ArrayOfLla;
    k = arrayOflla.length;
    i = j;
    while (i < k)
    {
      locallla = arrayOflla[i];
      if (locallla != null) {
        locallla.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Lla != null) {
      this.jdField_a_of_type_Lla.a();
    }
    if (this.jdField_a_of_type_Lkl != null) {
      this.jdField_a_of_type_Lkl.b();
    }
    if (this.jdField_a_of_type_Lkm != null) {
      this.jdField_a_of_type_Lkm.b();
    }
    if (this.jdField_a_of_type_Lke != null) {
      this.jdField_a_of_type_Lke.b();
    }
    if (this.jdField_a_of_type_Lkk != null) {
      this.jdField_a_of_type_Lkk.b();
    }
    if (this.jdField_a_of_type_AndroidOsVibrator != null) {
      this.jdField_a_of_type_AndroidOsVibrator.cancel();
    }
    if (this.jdField_a_of_type_Lkq != null) {
      this.jdField_a_of_type_Lkq.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "recycle mAVRedPacketManager set to null");
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = null;
    this.jdField_a_of_type_ArrayOfLla = null;
    this.jdField_b_of_type_ArrayOfLla = null;
    this.jdField_a_of_type_Lla = null;
    this.jdField_a_of_type_Lkg = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Lkl = null;
    this.jdField_a_of_type_Lki = null;
    this.jdField_a_of_type_Lkm = null;
    this.jdField_a_of_type_Lkx = null;
    this.jdField_a_of_type_Lky = null;
    this.jdField_a_of_type_Lke = null;
    this.jdField_a_of_type_Lkk = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_Lkq = null;
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
    this.jdField_a_of_type_Lkg.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lkl.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lki.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lkm.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lky.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lkx.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lke.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lkk.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lkq.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_Int = 0;
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Lkg.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Lkg.b(a(localLocalEmojiInfo));
      int i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_Lkg.b(i);
      this.jdField_a_of_type_Lkg.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Lkg.jdField_a_of_type_Lkh = new ljz(this);
      this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla = this.jdField_a_of_type_ArrayOfLla[localLocalEmojiInfo.emojiType];
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lkg.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, 0L);
      }
      this.jdField_a_of_type_Lkl.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Lkl.a(localLocalEmojiInfo.isBigEmoji);
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    this.jdField_a_of_type_Lkg.a(paramCanvas, paramPaint);
    this.jdField_a_of_type_Lkl.a(paramCanvas, paramPaint);
    int k;
    int m;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      Rect localRect = this.jdField_a_of_type_Lki.a();
      k = localRect.left;
      m = localRect.top;
      if (!lbu.a()) {
        break label155;
      }
      j = this.c;
    }
    for (int i = this.d;; i = this.f)
    {
      paramCanvas.translate(j - k, i - m);
      this.jdField_a_of_type_Lkm.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lki.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lkq.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lke.a(paramCanvas, paramPaint);
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.restore();
      }
      this.jdField_a_of_type_Lky.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lkk.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lkx.a(paramCanvas, paramPaint);
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
  
  public void a(AVRedPacketManager paramAVRedPacketManager, lla[] paramArrayOflla)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLla.length)
    {
      this.jdField_a_of_type_ArrayOfLla[i] = new lla(paramAVRedPacketManager.a("qav_redpacket_emoji_" + (i + 1) + ".png"));
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfLla[0] = new lla(paramAVRedPacketManager.a("qav_redpacket_perfect.png"));
    this.jdField_b_of_type_ArrayOfLla[1] = new lla(paramAVRedPacketManager.a("qav_redpacket_cool.png"));
    this.jdField_b_of_type_ArrayOfLla[2] = new lla(paramAVRedPacketManager.a("qav_redpacket_miss.png"));
    this.jdField_b_of_type_ArrayOfLla[3] = new lla(paramAVRedPacketManager.a("qav_redpacket_excellent.png"));
    this.jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_miss_background.png"));
    this.jdField_a_of_type_Lke.a(paramAVRedPacketManager, paramArrayOflla);
    this.jdField_a_of_type_Lkk.a(paramAVRedPacketManager);
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
      this.jdField_a_of_type_Lki.jdField_a_of_type_Long = l;
      Rect localRect = this.jdField_a_of_type_Lkg.a();
      this.jdField_a_of_type_Lki.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.jdField_a_of_type_Lkm.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lkm.c();
      this.jdField_a_of_type_Lky.jdField_a_of_type_Lla = null;
      this.jdField_a_of_type_Lky.b(-12375);
      this.jdField_a_of_type_Lke.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lke.c();
      this.jdField_a_of_type_Lke.a(paramLocalFrameSyncInfo.localHitInfo.comboCnt, paramLocalFrameSyncInfo.localHitInfo.newAddScore);
      this.jdField_a_of_type_Lkq.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lkq.c();
      if ((localLocalEmojiInfo != null) && (localLocalEmojiInfo.emojiId == paramLocalFrameSyncInfo.localHitInfo.emojiId))
      {
        this.jdField_a_of_type_Lki.jdField_a_of_type_Lla = this.jdField_a_of_type_ArrayOfLla[localLocalEmojiInfo.emojiType];
        this.jdField_a_of_type_Lki.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lke.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lkm.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lkx.a(localLocalEmojiInfo.isBigEmoji);
      }
      for (;;)
      {
        this.jdField_a_of_type_Lky.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Lkx.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Lkx.jdField_a_of_type_Lla = this.jdField_b_of_type_ArrayOfLla[(paramLocalFrameSyncInfo.localHitInfo.topWordTipType - 1)];
        if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 4) {
          break;
        }
        this.jdField_a_of_type_Lkk.jdField_a_of_type_Long = l;
        return;
        l = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
        break label105;
        label413:
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label473;
        }
        localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(paramLocalFrameSyncInfo.localHitInfo.emojiId);
        break label132;
        this.jdField_a_of_type_Lki.jdField_a_of_type_Lla = this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla;
      }
      label473:
      localLocalEmojiInfo = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Lkg.a(true);
  }
  
  public void b(long paramLong)
  {
    long l1 = paramLong - this.jdField_a_of_type_Lkg.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Boolean) {
      if ((l1 > this.jdField_a_of_type_Lkg.a()) && (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Lky.jdField_a_of_type_Lla = this.jdField_a_of_type_Lla;
        this.jdField_a_of_type_Lky.b(-9942110);
        l1 = this.jdField_a_of_type_Lkg.jdField_a_of_type_Long + this.jdField_a_of_type_Lkg.a();
        if (this.jdField_a_of_type_Lky.jdField_a_of_type_Long != l1)
        {
          this.jdField_a_of_type_Lky.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_Lkx.jdField_a_of_type_Long = l1;
          a(3, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameEmojiAnimation", 2, "send show miss mCurEmojiItemId = " + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Lkx.jdField_a_of_type_Lla = this.jdField_b_of_type_ArrayOfLla[2];
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Lkg.a(paramLong);
      this.jdField_a_of_type_Lkl.a(paramLong);
      this.jdField_a_of_type_Lki.a(paramLong);
      this.jdField_a_of_type_Lkm.a(paramLong);
      this.jdField_a_of_type_Lky.a(paramLong);
      this.jdField_a_of_type_Lkx.a(paramLong);
      this.jdField_a_of_type_Lke.a(paramLong);
      this.jdField_a_of_type_Lkk.a(paramLong);
      this.jdField_a_of_type_Lkq.a(paramLong);
      return;
      if ((l1 > this.jdField_a_of_type_Lkg.a()) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Lky.jdField_a_of_type_Lla = this.jdField_a_of_type_Lla;
          this.jdField_a_of_type_Lky.b(-9942110);
          this.jdField_a_of_type_Lky.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lkx.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lkx.jdField_a_of_type_Lla = this.jdField_b_of_type_ArrayOfLla[2];
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_Lkg.a(false);
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          lkg locallkg = this.jdField_a_of_type_Lkg;
          locallkg.jdField_a_of_type_Long += this.jdField_a_of_type_Lkg.a() + 500L;
          this.jdField_a_of_type_Lkg.b(a(localLocalEmojiInfo));
          int i = this.jdField_a_of_type_Int % 3;
          this.jdField_a_of_type_Lkg.b(i);
          this.jdField_a_of_type_Lkg.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla = this.jdField_a_of_type_ArrayOfLla[localLocalEmojiInfo.emojiType];
          this.jdField_a_of_type_Lkl.a(localLocalEmojiInfo.isBigEmoji);
          long l2 = this.jdField_a_of_type_Lkg.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lkg.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
          }
        }
        else if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Lky.jdField_a_of_type_Lla = this.jdField_a_of_type_Lla;
          this.jdField_a_of_type_Lky.b(-9942110);
          this.jdField_a_of_type_Lky.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lkx.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lkx.jdField_a_of_type_Lla = this.jdField_b_of_type_ArrayOfLla[2];
          this.jdField_a_of_type_Int += 1;
        }
      }
    }
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_a_of_type_Lkl.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lkm.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lkq.a(paramAVRedPacketManager);
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
          this.jdField_a_of_type_Lkg.b(a(paramLocalFrameSyncInfo));
          this.jdField_a_of_type_Lkg.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_Lkg.b(paramLocalFrameSyncInfo.trackNum);
          this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla = this.jdField_a_of_type_ArrayOfLla[paramLocalFrameSyncInfo.emojiType];
          this.jdField_a_of_type_Lkl.a(paramLocalFrameSyncInfo.isBigEmoji);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramLocalFrameSyncInfo.emojiId, paramLocalFrameSyncInfo.emojiType);
          }
        }
      }
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla = null;
      }
    }
    while ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Lkg.a(false);
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    int i;
    long l2;
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + localLocalEmojiInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_Lkg.jdField_a_of_type_Long = (paramLocalFrameSyncInfo.localHitInfo.hitStartTime + 500L);
      this.jdField_a_of_type_Lkg.b(a(localLocalEmojiInfo));
      i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_Lkg.b(i);
      this.jdField_a_of_type_Lkg.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla = this.jdField_a_of_type_ArrayOfLla[localLocalEmojiInfo.emojiType];
      l2 = this.jdField_a_of_type_Lkg.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
      if (l2 >= 0L) {
        break label577;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lkg.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
      }
      this.jdField_a_of_type_Lkl.a(localLocalEmojiInfo.isBigEmoji);
      return;
      this.jdField_a_of_type_Lkg.jdField_a_of_type_Lla = null;
      return;
      label577:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljy
 * JD-Core Version:    0.7.0.1
 */