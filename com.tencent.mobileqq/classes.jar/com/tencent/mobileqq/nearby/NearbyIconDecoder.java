package com.tencent.mobileqq.nearby;

import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.richstatus.BitmapDecoder;
import com.tencent.mobileqq.richstatus.BitmapDecoder.IBitmapListener;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearbyIconDecoder
  implements Handler.Callback, BitmapDecoder.IBitmapListener, IIconDecoder
{
  List<IIconDecoder.IIconListener> a;
  HashMap<String, String> b;
  List<String> c;
  List<String> d;
  BitmapDecoder e;
  INearbyAppInterface f;
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    NearbyUtils.a("NearbyIconDecoder", "notifyGetIcon", new Object[] { paramString, paramBitmap });
    ((NearbyAppInterfaceImpl)this.f).runOnUiThread(new NearbyIconDecoder.1(this, paramString, paramBitmap));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    synchronized (this.d)
    {
      this.d.remove(paramString1);
      synchronized (this.c)
      {
        this.c.remove(paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          synchronized (this.b)
          {
            this.b.put(paramString1, paramString2);
            if (this.e == null) {
              this.e = new BitmapDecoder("StatusIcon_", this);
            }
            ??? = this.e.a(paramString1, null, paramString2);
            if (??? != null) {
              a(paramString1, (Bitmap)???);
            }
          }
        }
        NearbyUtils.a("NearbyIconDecoder", "onGetIconUrl", new Object[] { paramString1, paramString2, Integer.valueOf(this.d.size()), Integer.valueOf(this.c.size()) });
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    NearbyUtils.a("NearbyIconDecoder", "onDecodeBitmap", new Object[] { paramString1, paramString2, paramBitmap, Integer.valueOf(paramInt) });
    if (paramString1 == null) {
      return;
    }
    if (paramBitmap != null) {
      a(paramString1, paramBitmap);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    NearbyUtils.a("NearbyIconDecoder", "MSG_GET_ICON_URL", new Object[] { Integer.valueOf(this.c.size()), Integer.valueOf(this.d.size()) });
    paramMessage = new ArrayList(this.c.size());
    synchronized (this.c)
    {
      paramMessage.addAll(this.c);
      this.c.clear();
      synchronized (this.d)
      {
        this.d.addAll(paramMessage);
        this.f.getNearbyProcManager().a(paramMessage);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyIconDecoder
 * JD-Core Version:    0.7.0.1
 */