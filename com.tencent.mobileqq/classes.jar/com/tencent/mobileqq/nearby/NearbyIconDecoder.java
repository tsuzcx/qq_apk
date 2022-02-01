package com.tencent.mobileqq.nearby;

import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
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
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  BitmapDecoder jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  List<IIconDecoder.IIconListener> jdField_a_of_type_JavaUtilList;
  List<String> b;
  List<String> c;
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    NearbyUtils.a("NearbyIconDecoder", "notifyGetIcon", new Object[] { paramString, paramBitmap });
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.runOnUiThread(new NearbyIconDecoder.1(this, paramString, paramBitmap));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    synchronized (this.c)
    {
      this.c.remove(paramString1);
      synchronized (this.b)
      {
        this.b.remove(paramString1);
        if (TextUtils.isEmpty(paramString2)) {}
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder = new BitmapDecoder("StatusIcon_", this);
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(paramString1, null, paramString2);
      if (??? != null) {
        a(paramString1, (Bitmap)???);
      }
      NearbyUtils.a("NearbyIconDecoder", "onGetIconUrl", new Object[] { paramString1, paramString2, Integer.valueOf(this.c.size()), Integer.valueOf(this.b.size()) });
      return;
      paramString1 = finally;
      throw paramString1;
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    NearbyUtils.a("NearbyIconDecoder", "onDecodeBitmap", new Object[] { paramString1, paramString2, paramBitmap, Integer.valueOf(paramInt) });
    if (paramString1 == null) {}
    while (paramBitmap == null) {
      return;
    }
    a(paramString1, paramBitmap);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    NearbyUtils.a("NearbyIconDecoder", "MSG_GET_ICON_URL", new Object[] { Integer.valueOf(this.b.size()), Integer.valueOf(this.c.size()) });
    paramMessage = new ArrayList(this.b.size());
    synchronized (this.b)
    {
      paramMessage.addAll(this.b);
      this.b.clear();
    }
    synchronized (this.c)
    {
      this.c.addAll(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramMessage);
      return false;
      paramMessage = finally;
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyIconDecoder
 * JD-Core Version:    0.7.0.1
 */