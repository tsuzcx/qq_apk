package cooperation.vip.ad;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class TianshuBreathLight
  extends ConversationActivePendantHolderBase
{
  private QQAppInterface a;
  private AnimationDrawableProxyView b;
  private TianShuAccess.AdItem c;
  
  public TianshuBreathLight(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.a = paramQQAppInterface;
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null)
    {
      QLog.e("ConvActivePendantHolderBase", 2, "showLayer with null ");
      return;
    }
    this.c = paramAdItem;
    Object localObject1 = paramAdItem.argList.get().iterator();
    paramAdItem = null;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("image")) {
        paramAdItem = ((TianShuAccess.MapEntry)localObject2).value.get();
      }
    }
    if (!TextUtils.isEmpty(paramAdItem))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_loop", 1);
      localObject2 = URLDrawableHelperConstants.a;
      this.B = VasApngUtil.getApngURLDrawable(paramAdItem, new int[] { 2 }, (Drawable)localObject2, (Bundle)localObject1, null);
      if (this.B != null)
      {
        this.b = new AnimationDrawableProxyView(this.m, this.n, this.B);
        d();
        paramAdItem = this.a;
        if (paramAdItem != null)
        {
          localObject1 = this.c;
          if (localObject1 != null) {
            TianshuAdUtils.a(paramAdItem, 101, String.valueOf(((TianShuAccess.AdItem)localObject1).iAdId.get()), this.c.traceinfo.get());
          }
        }
      }
    }
  }
  
  public void d()
  {
    try
    {
      int j = this.n.getWidth();
      int i = j;
      if (j == 0) {
        i = ScreenUtil.SCREEN_WIDTH;
      }
      j = AIOUtils.b(375.0F, this.n.getResources());
      a(i - j + 0, 0, j, AIOUtils.b(30.0F, this.n.getResources()), this.n);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ConvActivePendantHolderBase", 1, localThrowable, new Object[0]);
    }
  }
  
  public void h()
  {
    super.h();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      TianShuAccess.AdItem localAdItem = this.c;
      if (localAdItem != null)
      {
        TianshuAdUtils.a(localQQAppInterface, 102, String.valueOf(localAdItem.iAdId.get()), this.c.traceinfo.get());
        if ((this.n != null) && ((this.n instanceof ARMapHongBaoListView))) {
          ((ARMapHongBaoListView)this.n).i();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBreathLight
 * JD-Core Version:    0.7.0.1
 */