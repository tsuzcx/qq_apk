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

public class ltt
{
  public int a;
  public Vibrator a;
  public AVRedPacketManager a;
  public List<AVRedPacketManager.LocalEmojiInfo> a;
  public ltz a;
  public lub a;
  public lud a;
  public luf a;
  public lug a;
  public luh a;
  public lul a;
  public lus a;
  public lut a;
  public luv a;
  public boolean a;
  public luv[] a;
  public int b;
  private boolean b;
  public luv[] b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public ltt(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfLuv = new luv[10];
    this.jdField_b_of_type_ArrayOfLuv = new luv[4];
    this.jdField_a_of_type_Lub = new lub();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lug = new lug(this.jdField_a_of_type_Lub);
    this.jdField_a_of_type_Lud = new lud();
    this.jdField_a_of_type_Luh = new luh(this.jdField_a_of_type_Lud);
    this.jdField_a_of_type_Lus = new lus();
    this.jdField_a_of_type_Lut = new lut();
    this.jdField_a_of_type_Ltz = new ltz(this.jdField_a_of_type_Lud);
    this.jdField_a_of_type_Luf = new luf();
    this.jdField_a_of_type_Lul = new lul(this.jdField_a_of_type_Lud);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Lub.a(paramContext.getString(2131695151));
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
    luv[] arrayOfluv = this.jdField_a_of_type_ArrayOfLuv;
    int k = arrayOfluv.length;
    int i = 0;
    luv localluv;
    while (i < k)
    {
      localluv = arrayOfluv[i];
      if (localluv != null) {
        localluv.a();
      }
      i += 1;
    }
    arrayOfluv = this.jdField_b_of_type_ArrayOfLuv;
    k = arrayOfluv.length;
    i = j;
    while (i < k)
    {
      localluv = arrayOfluv[i];
      if (localluv != null) {
        localluv.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Luv != null) {
      this.jdField_a_of_type_Luv.a();
    }
    if (this.jdField_a_of_type_Lug != null) {
      this.jdField_a_of_type_Lug.b();
    }
    if (this.jdField_a_of_type_Luh != null) {
      this.jdField_a_of_type_Luh.b();
    }
    if (this.jdField_a_of_type_Ltz != null) {
      this.jdField_a_of_type_Ltz.b();
    }
    if (this.jdField_a_of_type_Luf != null) {
      this.jdField_a_of_type_Luf.b();
    }
    if (this.jdField_a_of_type_AndroidOsVibrator != null) {
      this.jdField_a_of_type_AndroidOsVibrator.cancel();
    }
    if (this.jdField_a_of_type_Lul != null) {
      this.jdField_a_of_type_Lul.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "recycle mAVRedPacketManager set to null");
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = null;
    this.jdField_a_of_type_ArrayOfLuv = null;
    this.jdField_b_of_type_ArrayOfLuv = null;
    this.jdField_a_of_type_Luv = null;
    this.jdField_a_of_type_Lub = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Lug = null;
    this.jdField_a_of_type_Lud = null;
    this.jdField_a_of_type_Luh = null;
    this.jdField_a_of_type_Lus = null;
    this.jdField_a_of_type_Lut = null;
    this.jdField_a_of_type_Ltz = null;
    this.jdField_a_of_type_Luf = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_Lul = null;
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
    this.jdField_a_of_type_Lub.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lug.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lud.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Luh.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lut.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lus.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Ltz.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Luf.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lul.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_Int = 0;
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Lub.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Lub.b(a(localLocalEmojiInfo));
      int i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_Lub.b(i);
      this.jdField_a_of_type_Lub.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Lub.jdField_a_of_type_Luc = new ltu(this);
      this.jdField_a_of_type_Lub.jdField_a_of_type_Luv = this.jdField_a_of_type_ArrayOfLuv[localLocalEmojiInfo.emojiType];
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lub.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, 0L);
      }
      this.jdField_a_of_type_Lug.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Lug.a(localLocalEmojiInfo.isBigEmoji);
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    this.jdField_a_of_type_Lub.a(paramCanvas, paramPaint);
    this.jdField_a_of_type_Lug.a(paramCanvas, paramPaint);
    int k;
    int m;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      Rect localRect = this.jdField_a_of_type_Lud.a();
      k = localRect.left;
      m = localRect.top;
      if (!llg.a()) {
        break label155;
      }
      j = this.c;
    }
    for (int i = this.d;; i = this.f)
    {
      paramCanvas.translate(j - k, i - m);
      this.jdField_a_of_type_Luh.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lud.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lul.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Ltz.a(paramCanvas, paramPaint);
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.restore();
      }
      this.jdField_a_of_type_Lut.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Luf.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_Lus.a(paramCanvas, paramPaint);
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
  
  public void a(AVRedPacketManager paramAVRedPacketManager, luv[] paramArrayOfluv)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLuv.length)
    {
      this.jdField_a_of_type_ArrayOfLuv[i] = new luv(paramAVRedPacketManager.a("qav_redpacket_emoji_" + (i + 1) + ".png"));
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfLuv[0] = new luv(paramAVRedPacketManager.a("qav_redpacket_perfect.png"));
    this.jdField_b_of_type_ArrayOfLuv[1] = new luv(paramAVRedPacketManager.a("qav_redpacket_cool.png"));
    this.jdField_b_of_type_ArrayOfLuv[2] = new luv(paramAVRedPacketManager.a("qav_redpacket_miss.png"));
    this.jdField_b_of_type_ArrayOfLuv[3] = new luv(paramAVRedPacketManager.a("qav_redpacket_excellent.png"));
    this.jdField_a_of_type_Luv = new luv(paramAVRedPacketManager.a("qav_redpacket_miss_background.png"));
    this.jdField_a_of_type_Ltz.a(paramAVRedPacketManager, paramArrayOfluv);
    this.jdField_a_of_type_Luf.a(paramAVRedPacketManager);
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
      this.jdField_a_of_type_Lud.jdField_a_of_type_Long = l;
      Rect localRect = this.jdField_a_of_type_Lub.a();
      this.jdField_a_of_type_Lud.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.jdField_a_of_type_Luh.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Luh.c();
      this.jdField_a_of_type_Lut.jdField_a_of_type_Luv = null;
      this.jdField_a_of_type_Lut.b(-12375);
      this.jdField_a_of_type_Ltz.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Ltz.c();
      this.jdField_a_of_type_Ltz.a(paramLocalFrameSyncInfo.localHitInfo.comboCnt, paramLocalFrameSyncInfo.localHitInfo.newAddScore);
      this.jdField_a_of_type_Lul.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Lul.c();
      if ((localLocalEmojiInfo != null) && (localLocalEmojiInfo.emojiId == paramLocalFrameSyncInfo.localHitInfo.emojiId))
      {
        this.jdField_a_of_type_Lud.jdField_a_of_type_Luv = this.jdField_a_of_type_ArrayOfLuv[localLocalEmojiInfo.emojiType];
        this.jdField_a_of_type_Lud.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Ltz.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Luh.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_Lus.a(localLocalEmojiInfo.isBigEmoji);
      }
      for (;;)
      {
        this.jdField_a_of_type_Lut.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Lus.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Lus.jdField_a_of_type_Luv = this.jdField_b_of_type_ArrayOfLuv[(paramLocalFrameSyncInfo.localHitInfo.topWordTipType - 1)];
        if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 4) {
          break;
        }
        this.jdField_a_of_type_Luf.jdField_a_of_type_Long = l;
        return;
        l = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
        break label105;
        label413:
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label473;
        }
        localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(paramLocalFrameSyncInfo.localHitInfo.emojiId);
        break label132;
        this.jdField_a_of_type_Lud.jdField_a_of_type_Luv = this.jdField_a_of_type_Lub.jdField_a_of_type_Luv;
      }
      label473:
      localLocalEmojiInfo = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Lub.a(true);
  }
  
  public void b(long paramLong)
  {
    long l1 = paramLong - this.jdField_a_of_type_Lub.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Boolean) {
      if ((l1 > this.jdField_a_of_type_Lub.a()) && (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Lut.jdField_a_of_type_Luv = this.jdField_a_of_type_Luv;
        this.jdField_a_of_type_Lut.b(-9942110);
        l1 = this.jdField_a_of_type_Lub.jdField_a_of_type_Long + this.jdField_a_of_type_Lub.a();
        if (this.jdField_a_of_type_Lut.jdField_a_of_type_Long != l1)
        {
          this.jdField_a_of_type_Lut.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_Lus.jdField_a_of_type_Long = l1;
          a(3, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameEmojiAnimation", 2, "send show miss mCurEmojiItemId = " + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Lus.jdField_a_of_type_Luv = this.jdField_b_of_type_ArrayOfLuv[2];
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Lub.a(paramLong);
      this.jdField_a_of_type_Lug.a(paramLong);
      this.jdField_a_of_type_Lud.a(paramLong);
      this.jdField_a_of_type_Luh.a(paramLong);
      this.jdField_a_of_type_Lut.a(paramLong);
      this.jdField_a_of_type_Lus.a(paramLong);
      this.jdField_a_of_type_Ltz.a(paramLong);
      this.jdField_a_of_type_Luf.a(paramLong);
      this.jdField_a_of_type_Lul.a(paramLong);
      return;
      if ((l1 > this.jdField_a_of_type_Lub.a()) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Lut.jdField_a_of_type_Luv = this.jdField_a_of_type_Luv;
          this.jdField_a_of_type_Lut.b(-9942110);
          this.jdField_a_of_type_Lut.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lus.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lus.jdField_a_of_type_Luv = this.jdField_b_of_type_ArrayOfLuv[2];
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_Lub.a(false);
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          lub locallub = this.jdField_a_of_type_Lub;
          locallub.jdField_a_of_type_Long += this.jdField_a_of_type_Lub.a() + 500L;
          this.jdField_a_of_type_Lub.b(a(localLocalEmojiInfo));
          int i = this.jdField_a_of_type_Int % 3;
          this.jdField_a_of_type_Lub.b(i);
          this.jdField_a_of_type_Lub.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Lub.jdField_a_of_type_Luv = this.jdField_a_of_type_ArrayOfLuv[localLocalEmojiInfo.emojiType];
          this.jdField_a_of_type_Lug.a(localLocalEmojiInfo.isBigEmoji);
          long l2 = this.jdField_a_of_type_Lub.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lub.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
          }
        }
        else if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_Lut.jdField_a_of_type_Luv = this.jdField_a_of_type_Luv;
          this.jdField_a_of_type_Lut.b(-9942110);
          this.jdField_a_of_type_Lut.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lus.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_Lus.jdField_a_of_type_Luv = this.jdField_b_of_type_ArrayOfLuv[2];
          this.jdField_a_of_type_Int += 1;
        }
      }
    }
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_a_of_type_Lug.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Luh.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lul.a(paramAVRedPacketManager);
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
          this.jdField_a_of_type_Lub.b(a(paramLocalFrameSyncInfo));
          this.jdField_a_of_type_Lub.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_Lub.b(paramLocalFrameSyncInfo.trackNum);
          this.jdField_a_of_type_Lub.jdField_a_of_type_Luv = this.jdField_a_of_type_ArrayOfLuv[paramLocalFrameSyncInfo.emojiType];
          this.jdField_a_of_type_Lug.a(paramLocalFrameSyncInfo.isBigEmoji);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramLocalFrameSyncInfo.emojiId, paramLocalFrameSyncInfo.emojiType);
          }
        }
      }
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Lub.jdField_a_of_type_Luv = null;
      }
    }
    while ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Lub.a(false);
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    int i;
    long l2;
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + localLocalEmojiInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_Lub.jdField_a_of_type_Long = (paramLocalFrameSyncInfo.localHitInfo.hitStartTime + 500L);
      this.jdField_a_of_type_Lub.b(a(localLocalEmojiInfo));
      i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_Lub.b(i);
      this.jdField_a_of_type_Lub.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Lub.jdField_a_of_type_Luv = this.jdField_a_of_type_ArrayOfLuv[localLocalEmojiInfo.emojiType];
      l2 = this.jdField_a_of_type_Lub.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
      if (l2 >= 0L) {
        break label577;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_Lub.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
      }
      this.jdField_a_of_type_Lug.a(localLocalEmojiInfo.isBigEmoji);
      return;
      this.jdField_a_of_type_Lub.jdField_a_of_type_Luv = null;
      return;
      label577:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ltt
 * JD-Core Version:    0.7.0.1
 */