package cooperation.vip.ad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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
import com.tencent.widget.ARMapHongBaoListView.onPendentClickListener;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class TianshuPendantHolder
  extends ConversationActivePendantHolderBase
  implements ARMapHongBaoListView.onPendentClickListener
{
  public static float a = 112.0F;
  private TianShuAccess.AdItem b;
  private QQAppInterface c;
  private TianshuPendantHolder.AnimationDrawableProxyView d;
  private Drawable e;
  private Rect f;
  private Rect g;
  private String h;
  
  public TianshuPendantHolder(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.c = paramQQAppInterface;
    if (this.e == null) {
      this.e = this.m.getResources().getDrawable(2130838346);
    }
  }
  
  private void a()
  {
    if ((this.n != null) && ((this.n instanceof ARMapHongBaoListView))) {
      ((ARMapHongBaoListView)this.n).setPendantHolder(null);
    }
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface != null)
    {
      TianShuAccess.AdItem localAdItem = this.b;
      if (localAdItem != null) {
        TianshuAdUtils.a(localQQAppInterface, 122, String.valueOf(localAdItem.iAdId.get()), this.b.traceinfo.get());
      }
    }
  }
  
  private void b()
  {
    TianshuAdUtils.a(this.c, this.m, this.h, 4004);
    if ((this.n != null) && ((this.n instanceof ARMapHongBaoListView)))
    {
      ((ARMapHongBaoListView)this.n).setPendantHolder(null);
      ((ARMapHongBaoListView)this.n).setOnPendentClickListener(null);
    }
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface != null)
    {
      TianShuAccess.AdItem localAdItem = this.b;
      if (localAdItem != null) {
        TianshuAdUtils.a(localQQAppInterface, 102, String.valueOf(localAdItem.iAdId.get()), this.b.traceinfo.get());
      }
    }
  }
  
  private void j()
  {
    try
    {
      this.B = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Rect localRect = this.g;
    if ((localRect != null) && (localRect.contains((int)paramFloat1, (int)paramFloat2)))
    {
      a();
      return;
    }
    b();
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null)
    {
      QLog.e("TianshuPendantHolder", 2, "showLayer with null ");
      return;
    }
    this.b = paramAdItem;
    this.h = null;
    Object localObject = paramAdItem.argList.get().iterator();
    paramAdItem = null;
    while (((Iterator)localObject).hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
      if (localMapEntry.key.get().equals("image")) {
        paramAdItem = localMapEntry.value.get();
      } else if (localMapEntry.key.get().equals("url")) {
        this.h = localMapEntry.value.get();
      }
    }
    if ((!TextUtils.isEmpty(paramAdItem)) && (!TextUtils.isEmpty(this.h)))
    {
      localObject = URLDrawableHelperConstants.a;
      this.B = VasApngUtil.getApngURLDrawable(paramAdItem, new int[] { 2 }, (Drawable)localObject, null, null);
      if (this.B != null)
      {
        this.d = new TianshuPendantHolder.AnimationDrawableProxyView(this, this.m, this.n, this.B);
        paramAdItem = this.c;
        if (paramAdItem != null)
        {
          localObject = this.b;
          if (localObject != null) {
            TianshuAdUtils.a(paramAdItem, 101, String.valueOf(((TianShuAccess.AdItem)localObject).iAdId.get()), this.b.traceinfo.get());
          }
        }
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setpendantres error with image url ");
      ((StringBuilder)localObject).append(paramAdItem);
      ((StringBuilder)localObject).append(" jumpUrl ");
      ((StringBuilder)localObject).append(this.h);
      QLog.e("TianshuPendantHolder", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(float paramFloat1, float paramFloat2) {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  protected void b(Canvas paramCanvas) {}
  
  public RectF c(int paramInt)
  {
    float f1 = -AIOUtils.b(20.0F, this.n.getResources());
    RectF localRectF = this.k;
    float f2 = this.x;
    float f3 = this.y;
    float f4 = paramInt;
    localRectF.set(f2 - f1, f3 - f1 - f4, this.x + this.z + f1, this.y + this.A + f1 - f4);
    return this.k;
  }
  
  public void c()
  {
    try
    {
      j();
      if (QLog.isColorLevel())
      {
        QLog.i("TianshuPendantHolder", 2, "stopAnimation...");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  protected void c(Canvas paramCanvas)
  {
    super.c(paramCanvas);
    if (this.e != null)
    {
      paramCanvas.save();
      this.e.setBounds(this.f);
      this.e.draw(paramCanvas);
      paramCanvas.restore();
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
      j = AIOUtils.b(160.0F, this.n.getResources());
      a(i - j + 0, 0, j, AIOUtils.b(a, this.n.getResources()), this.n);
      this.f = new Rect(this.x + j - AIOUtils.b(23.0F, this.n.getResources()), this.y + AIOUtils.b(22.0F, this.n.getResources()), this.x + j - AIOUtils.b(8.0F, this.n.getResources()), this.y + AIOUtils.b(37.0F, this.n.getResources()));
      this.g = new Rect(this.x + j - AIOUtils.b(23.0F, this.n.getResources()), this.y, this.x + j, this.y + AIOUtils.b(37.0F, this.n.getResources()));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuPendantHolder
 * JD-Core Version:    0.7.0.1
 */