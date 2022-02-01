package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchTextView
  extends TextView
{
  public Drawable a;
  public Drawable b;
  public Drawable c;
  public String d = "";
  private Rect e = new Rect();
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private int l;
  private BusinessInfoCheckUpdate.AppInfo m;
  private List<BusinessInfoCheckUpdate.RedTypeInfo> n;
  private int o = 100;
  private String p = "";
  private Handler q;
  private boolean r = false;
  
  public RedTouchTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = this.f;
    this.g = i1;
    this.h = i1;
    this.j = a(9);
    this.k = a(9);
    this.l = a(4);
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (a(paramRedTypeInfo, this.m))
    {
      int i2;
      int i1;
      if (this.i)
      {
        i2 = this.g;
        i1 = this.l;
      }
      else
      {
        i2 = this.f;
        i1 = this.l;
      }
      return i2 + i1;
    }
    if (this.i) {
      return this.g;
    }
    return this.f;
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramRedTypeInfo == null) {
      return 0;
    }
    int i3 = paramRedTypeInfo.red_type.get();
    if (i3 != 0)
    {
      int i2;
      if (i3 != 9)
      {
        if (i3 != 15)
        {
          if (i3 != 3)
          {
            if ((i3 == 4) || (i3 == 5))
            {
              this.p = paramRedTypeInfo.red_content.get();
              paramRedTypeInfo = new TextPaint();
              paramRedTypeInfo.setTextSize(a(11));
              i2 = (int)paramRedTypeInfo.measureText(this.p);
              i1 = i2;
              if (paramBoolean) {
                i1 = i2 + a(6) * 2;
              }
            }
          }
          else {
            i1 = a(paramRedTypeInfo);
          }
        }
        else {
          i1 = a(paramRedTypeInfo);
        }
      }
      else
      {
        paramRedTypeInfo = paramRedTypeInfo.red_content.get();
        try
        {
          i2 = Integer.valueOf(paramRedTypeInfo).intValue();
          i1 = i2;
        }
        catch (Exception paramRedTypeInfo)
        {
          QLog.e("RedTouchTextView", 1, "getRedTypeInfoWidth exception e = ", paramRedTypeInfo);
        }
      }
    }
    else
    {
      i1 = this.j;
    }
    if (QLog.isColorLevel())
    {
      paramRedTypeInfo = new StringBuilder();
      paramRedTypeInfo.append("getRedTypeInfoWidth type = ");
      paramRedTypeInfo.append(i3);
      paramRedTypeInfo.append(",width = ");
      paramRedTypeInfo.append(i1);
      QLog.d("RedTouchTextView", 2, paramRedTypeInfo.toString());
    }
    return i1;
  }
  
  private int a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    int i3 = 0;
    int i2 = 0;
    boolean bool;
    if ((paramList != null) && (paramList.size() <= 2)) {
      bool = true;
    } else {
      bool = false;
    }
    int i1 = i3;
    if (paramList != null)
    {
      i1 = i3;
      if (paramList.size() > 0)
      {
        i1 = 0;
        while (i2 < paramList.size())
        {
          i1 += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i2), bool);
          i2 += 1;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWidthByRedInfoList size = ");
          localStringBuilder.append(paramList.size());
          QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getWidthByRedInfoList width = ");
      paramList.append(i1);
      QLog.d("RedTouchTextView", 2, paramList.toString());
    }
    return i1;
  }
  
  private int a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt)
  {
    int i3 = 0;
    int i1 = 0;
    boolean bool;
    if ((paramList != null) && (paramList.size() <= 2)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder;
    if ((paramList != null) && ((paramInt > paramList.size() - 1) || (paramInt < 0)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWidthByRedInfoListByPosition error, size = ");
        localStringBuilder.append(paramList.size());
        localStringBuilder.append(" position = ");
        localStringBuilder.append(paramInt);
        QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
      }
      return 0;
    }
    int i2 = i3;
    if (paramList != null)
    {
      i2 = i3;
      if (paramList.size() > 0)
      {
        i2 = paramList.size() - 1;
        while (i2 >= paramInt)
        {
          i1 += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i2), bool);
          i2 -= 1;
        }
        i2 = i1;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWidthByRedInfoListByPosition size = ");
          localStringBuilder.append(paramList.size());
          QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
          i2 = i1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getWidthByRedInfoListByPosition width = ");
      paramList.append(i2);
      QLog.d("RedTouchTextView", 2, paramList.toString());
    }
    return i2;
  }
  
  public static List<BusinessInfoCheckUpdate.RedTypeInfo> a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return null;
    }
    paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
      }
      return null;
    }
    paramAppInfo = paramAppInfo.red_type_info.get();
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null");
      }
      return null;
    }
    if (paramAppInfo.size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2");
      }
      return null;
    }
    return paramAppInfo;
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject1;
    int i1;
    Object localObject2;
    int i2;
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "drawRed start draw");
      }
      localObject1 = this.n;
      if ((localObject1 != null) && (((List)localObject1).size() >= 1))
      {
        i1 = this.n.size() - 1;
        if (i1 < 0) {
          break label228;
        }
        localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)this.n.get(i1);
        i2 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get())) {
          localObject1 = new JSONObject();
        } else {
          localObject1 = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get());
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("drawRed Exception ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("RedTouchTextView", 1, ((StringBuilder)localObject2).toString());
      }
      a(paramCanvas, i1, i2);
      c(paramCanvas, i1, (BusinessInfoCheckUpdate.RedTypeInfo)localObject2, i2, (JSONObject)localObject1);
      a(paramCanvas, i1, (BusinessInfoCheckUpdate.RedTypeInfo)localObject2, i2, (JSONObject)localObject1);
      b(paramCanvas, i1, (BusinessInfoCheckUpdate.RedTypeInfo)localObject2, i2, (JSONObject)localObject1);
      i1 -= 1;
      break;
      QLog.e("RedTouchTextView", 1, "drawRed showRedInfo = null");
      label228:
      return;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouchpoint");
      }
      paramInt1 = getWidth() - a(this.n, paramInt1) - a(0);
      paramInt2 = getHeight() / 2 - this.j / 2;
      this.a = getResources().getDrawable(2130852588);
      Drawable localDrawable = this.a;
      int i1 = this.j;
      localDrawable.setBounds(paramInt1, paramInt2, paramInt1 + i1, i1 + paramInt2);
      this.a.draw(paramCanvas);
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt2 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch img");
      }
      int i2 = getWidth() - a(this.n, paramInt1) - a(0);
      int i3 = getHeight() / 2 - this.h / 2;
      if (paramJSONObject.has("av")) {
        paramInt1 = paramJSONObject.getInt("av");
      } else {
        paramInt1 = 0;
      }
      if (paramJSONObject.has("dot")) {
        paramInt2 = paramJSONObject.getInt("dot");
      } else {
        paramInt2 = 0;
      }
      int i1;
      if (paramJSONObject.has("st")) {
        i1 = Integer.valueOf(paramJSONObject.getString("st")).intValue();
      } else {
        i1 = 0;
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      if (i1 == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "draw redtouch img gif ");
        }
        paramJSONObject = getResources().getDrawable(2130841060);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramJSONObject;
        localURLDrawableOptions.mFailedDrawable = paramJSONObject;
        localURLDrawableOptions.mRequestWidth = this.g;
        localURLDrawableOptions.mRequestHeight = this.h;
        localURLDrawableOptions.mPlayGifImage = true;
        paramRedTypeInfo = URLDrawable.getDrawable(paramRedTypeInfo, localURLDrawableOptions);
        paramRedTypeInfo.setCallback(this);
        paramRedTypeInfo.draw(paramCanvas);
        paramRedTypeInfo = this.b;
        if (paramRedTypeInfo != null)
        {
          paramRedTypeInfo.setBounds(i2, i3, this.g + i2, this.h + i3);
          this.b.draw(paramCanvas);
        }
      }
      else if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "draw redtouch img static ");
        }
        paramJSONObject = this.b;
        if (paramJSONObject != null)
        {
          paramJSONObject.setBounds(i2, i3, this.g + i2, this.h + i3);
          this.b.draw(paramCanvas);
        }
        if (paramInt2 == 1)
        {
          paramJSONObject = getResources().getDrawable(2130852588);
          paramJSONObject.setBounds(getWidth() - a(0) - a(9), i3 - a(4), getWidth() - a(0), i3 + a(5));
          paramJSONObject.draw(paramCanvas);
        }
        if ((this.b == null) && (!TextUtils.isEmpty(paramRedTypeInfo))) {
          ThreadManager.post(new RedTouchTextView.1(this, paramRedTypeInfo, paramInt1), 8, null, true);
        }
      }
    }
  }
  
  public static boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo != null) && (paramRedTypeInfo.red_type.get() == 3)) {
      return d(paramRedTypeInfo, paramAppInfo);
    }
    return false;
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt1, int paramInt2)
  {
    int i6 = getRedInfoMaxShowWidth();
    int i1 = paramInt1;
    for (;;)
    {
      int i4 = 0;
      if ((i1 <= i6) || (paramInt2 <= 1)) {
        break;
      }
      int i5 = paramList.size();
      int i3 = 0;
      int i2;
      for (;;)
      {
        i1 = i4;
        i2 = i5;
        paramInt1 = paramInt2;
        if (i3 >= i5) {
          break;
        }
        if (((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i3)).red_type.get() != 9)
        {
          paramList.remove(i3);
          paramInt1 = paramInt2 - 1;
          i2 = i5 - 1;
          i1 = i4;
          break;
        }
        i3 += 1;
      }
      while (i1 < i2 - 1)
      {
        if ((((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i1)).red_type.get() == 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i1 + 1)).red_type.get() == 9))
        {
          paramList.remove(i1);
          break;
        }
        i1 += 1;
      }
      i1 = a(paramList);
      paramInt2 = paramInt1;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    if ((i1 > i6) && (paramInt2 == 1))
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt1);
        if ((localRedTypeInfo.red_type.get() == 3) && (a(localRedTypeInfo, this.m))) {
          setImageRedNotShowRedPoint(localRedTypeInfo, this.m);
        }
        paramInt1 += 1;
      }
    }
    if ((a(paramList) > i6) && (paramInt2 == 1))
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt1);
        if ((localRedTypeInfo.red_type.get() != 9) && (localRedTypeInfo.red_type.get() != 0))
        {
          localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(0);
          paramList.set(paramInt1, localRedTypeInfo);
        }
        paramInt1 += 1;
      }
    }
    return a(paramList) > i6;
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList1, List<BusinessInfoCheckUpdate.RedTypeInfo> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if ((paramList1.size() == paramList2.size()) && (paramList1.size() != 0))
      {
        int i1 = 0;
        while (i1 < paramList1.size())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList1.get(i1);
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList2.get(i1);
          if (localRedTypeInfo1.red_type.get() != localRedTypeInfo2.red_type.get()) {
            return false;
          }
          if (!localRedTypeInfo1.red_content.get().equals(localRedTypeInfo2.red_content.get())) {
            return false;
          }
          if (!localRedTypeInfo1.red_desc.get().equals(localRedTypeInfo2.red_desc.get())) {
            return false;
          }
          if (localRedTypeInfo1.red_priority.get() != localRedTypeInfo2.red_priority.get()) {
            return false;
          }
          i1 += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  private void b(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt2 == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch diffimg");
      }
      paramInt2 = getWidth() - a(this.n, paramInt1) - a(0);
      int i1 = getHeight() / 2 - this.h / 2;
      if (paramJSONObject.has("av")) {
        paramJSONObject.getInt("av");
      }
      if (paramJSONObject.has("dot")) {
        paramInt1 = paramJSONObject.getInt("dot");
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 == 1)
      {
        paramRedTypeInfo = getResources().getDrawable(2130852588);
        paramRedTypeInfo.setBounds(getWidth() - a(0) - a(9), i1 - a(4), getWidth() - a(0), a(5) + i1);
        paramRedTypeInfo.draw(paramCanvas);
      }
      paramRedTypeInfo = this.c;
      if (paramRedTypeInfo != null)
      {
        paramInt1 = paramRedTypeInfo.getIntrinsicWidth() / 2;
        this.c.setBounds(this.g + paramInt2 - a(paramInt1), i1, paramInt2 + this.g, this.h + i1);
        this.c.setCallback(this);
        this.c.draw(paramCanvas);
      }
    }
  }
  
  private boolean b()
  {
    Object localObject = this.m;
    if (localObject == null)
    {
      QLog.d("RedTouchTextView", 1, "isSupportRedTouch appinfo = null");
      return false;
    }
    if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportRedTouch inewflag = 0, path = ");
      ((StringBuilder)localObject).append(this.m.path);
      QLog.d("RedTouchTextView", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    localObject = (BusinessInfoCheckUpdate.RedDisplayInfo)this.m.red_display_info.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTypeInfoFromAppInfo diplayInfo = null, path = ");
        ((StringBuilder)localObject).append(this.m.path.get());
        QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    localObject = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTypeInfoFromAppInfo redInfos = null, path = ");
        ((StringBuilder)localObject).append(this.m.path.get());
        QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (((List)localObject).size() < 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTypeInfoFromAppInfo redInfos.size < 2, path = ");
        ((StringBuilder)localObject).append(this.m.path.get());
        QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    localObject = new ArrayList((Collection)localObject);
    int i2 = a((List)localObject);
    Iterator localIterator = ((List)localObject).iterator();
    int i1 = 0;
    while (localIterator.hasNext()) {
      if (((BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next()).red_type.get() != 9) {
        i1 += 1;
      }
    }
    if (i1 == 0)
    {
      QLog.e("RedTouchTextView", 1, "isSupportRedTouch notSpaceInfoCount = 0");
      return false;
    }
    if (a((List)localObject, i2, i1)) {
      return false;
    }
    setShowRedInfo((List)localObject);
    return true;
  }
  
  public static boolean b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo != null) && (paramRedTypeInfo.red_type.get() == 15)) {
      return d(paramRedTypeInfo, paramAppInfo);
    }
    return false;
  }
  
  private void c(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch text");
      }
      paramInt2 = -1;
      if (paramJSONObject.has("cr")) {
        paramInt2 = a(paramJSONObject.getString("cr"));
      }
      int i1;
      if (paramJSONObject.has("cn")) {
        i1 = a(paramJSONObject.getString("cn"));
      } else {
        i1 = 0;
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      paramJSONObject = new Paint(1);
      paramJSONObject.setTextSize(a(11));
      paramJSONObject.setTextAlign(Paint.Align.LEFT);
      int i3 = (int)paramJSONObject.measureText(paramRedTypeInfo);
      Object localObject = paramJSONObject.getFontMetrics();
      int i4 = (int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
      int i2 = getWidth() - a(0) - a(this.n, paramInt1);
      paramInt1 = getHeight() / 2 - i4 / 2 - a(2);
      Rect localRect = new Rect();
      localRect.left = i2;
      localRect.top = paramInt1;
      localRect.right = (i3 + i2);
      if (this.n.size() <= 2) {
        localRect.right += a(6) * 2;
      }
      localRect.bottom = (i4 + paramInt1 + a(2) * 2);
      float f1 = a(2) + paramInt1;
      float f2 = ((Paint.FontMetrics)localObject).top;
      if (i1 != 0)
      {
        localObject = getResources().getDrawable(2130852592);
        ((Drawable)localObject).getBounds();
        ((Drawable)localObject).setBounds(i2, paramInt1, localRect.right, localRect.bottom);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramJSONObject.setColor(paramInt2);
      paramInt1 = i2;
      if (this.n.size() <= 2) {
        paramInt1 = i2 + a(6);
      }
      paramCanvas.drawText(paramRedTypeInfo, paramInt1, f1 - f2, paramJSONObject);
    }
  }
  
  private static void c(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    try
    {
      JSONObject localJSONObject;
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
        localJSONObject = new JSONObject();
      } else {
        localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get());
      }
      if (localJSONObject.has("dot")) {
        localJSONObject.put("dot", 0);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageRedNotShowRedPoint ,path = ");
        localStringBuilder.append(paramAppInfo.path.get());
        QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
      }
      paramRedTypeInfo.red_desc.set(localJSONObject.toString());
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      paramAppInfo = new StringBuilder();
      paramAppInfo.append("setImageRedNotShowRedPoint json exception e = ");
      paramAppInfo.append(paramRedTypeInfo.getMessage());
      QLog.e("RedTouchTextView", 1, paramAppInfo.toString());
    }
  }
  
  private static boolean d(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool = false;
    int i1;
    try
    {
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
        paramRedTypeInfo = new JSONObject();
      } else {
        paramRedTypeInfo = new JSONObject(paramRedTypeInfo.red_desc.get());
      }
      if (paramRedTypeInfo.has("dot")) {
        i1 = paramRedTypeInfo.getInt("dot");
      } else {
        i1 = 0;
      }
      i2 = i1;
      try
      {
        if (!QLog.isColorLevel()) {
          break label174;
        }
        paramRedTypeInfo = new StringBuilder();
        paramRedTypeInfo.append("isSupportRedTouch had dot = ");
        paramRedTypeInfo.append(i1);
        paramRedTypeInfo.append(",path = ");
        paramRedTypeInfo.append(paramAppInfo.path.get());
        QLog.d("RedTouchTextView", 2, paramRedTypeInfo.toString());
        i2 = i1;
      }
      catch (Exception paramRedTypeInfo) {}
      paramAppInfo = new StringBuilder();
    }
    catch (Exception paramRedTypeInfo)
    {
      i1 = 0;
    }
    paramAppInfo.append("isSupportRedTouch json exception e = ");
    paramAppInfo.append(paramRedTypeInfo.getMessage());
    QLog.e("RedTouchTextView", 1, paramAppInfo.toString());
    int i2 = i1;
    label174:
    if (i2 == 1) {
      bool = true;
    }
    return bool;
  }
  
  private int getDrawableViewHeight()
  {
    return getHeight();
  }
  
  private int getDrawableViewWidth()
  {
    String str = getText().toString();
    TextPaint localTextPaint = getPaint();
    localTextPaint.getTextBounds(str, 0, str.length(), this.e);
    float f1 = Layout.getDesiredWidth(str, localTextPaint);
    return (int)(getWidth() - f1 - getPaddingLeft() - a(0) - a(0));
  }
  
  private int getRedInfoMaxShowWidth()
  {
    String str = getText().toString();
    TextPaint localTextPaint = getPaint();
    localTextPaint.getTextBounds(str, 0, str.length(), this.e);
    float f1 = Layout.getDesiredWidth(str, localTextPaint);
    return (int)(getWidth() - f1 - getPaddingLeft() - a(0) - a(0));
  }
  
  public static void setDiffImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramRedTypeInfo != null)
    {
      if (paramRedTypeInfo.red_type.get() != 15) {
        return;
      }
      c(paramRedTypeInfo, paramAppInfo);
    }
  }
  
  public static void setImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramRedTypeInfo != null)
    {
      if (paramRedTypeInfo.red_type.get() != 3) {
        return;
      }
      c(paramRedTypeInfo, paramAppInfo);
    }
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("#"))) {
      return Color.parseColor(paramString);
    }
    return 0;
  }
  
  /* Error */
  protected android.graphics.Bitmap a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual 583	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore_3
    //   11: new 585	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 586	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 4
    //   20: new 588	java/io/BufferedInputStream
    //   23: dup
    //   24: new 590	java/io/FileInputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 591	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 594	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 46	com/tencent/mobileqq/redtouch/RedTouchTextView:i	Z
    //   42: ifne +34 -> 76
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: ldc_w 596
    //   52: invokestatic 602	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   55: checkcast 596	com/tencent/mobileqq/activity/qqsettingme/api/IRedTouchTextViewApi
    //   58: aload_2
    //   59: aload_0
    //   60: getfield 50	com/tencent/mobileqq/redtouch/RedTouchTextView:k	I
    //   63: aload_0
    //   64: getfield 50	com/tencent/mobileqq/redtouch/RedTouchTextView:k	I
    //   67: invokeinterface 606 4 0
    //   72: d2i
    //   73: putfield 609	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   76: aload_2
    //   77: astore_1
    //   78: new 588	java/io/BufferedInputStream
    //   81: dup
    //   82: new 590	java/io/FileInputStream
    //   85: dup
    //   86: aload_3
    //   87: invokespecial 591	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   90: invokespecial 594	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: aconst_null
    //   94: aload 4
    //   96: invokestatic 615	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   99: astore_3
    //   100: aload_2
    //   101: invokevirtual 618	java/io/BufferedInputStream:close	()V
    //   104: aload_3
    //   105: areturn
    //   106: astore_1
    //   107: new 139	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   114: astore_2
    //   115: aload_2
    //   116: ldc_w 620
    //   119: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: aload_1
    //   125: invokevirtual 520	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 126
    //   134: iconst_1
    //   135: aload_2
    //   136: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_3
    //   143: areturn
    //   144: astore_3
    //   145: goto +16 -> 161
    //   148: astore_3
    //   149: goto +110 -> 259
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: goto +200 -> 355
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: new 139	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   170: astore 4
    //   172: aload_2
    //   173: astore_1
    //   174: aload 4
    //   176: ldc_w 620
    //   179: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_2
    //   184: astore_1
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 621	java/lang/Error:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: astore_1
    //   197: ldc 126
    //   199: iconst_1
    //   200: aload 4
    //   202: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_2
    //   209: ifnull +45 -> 254
    //   212: aload_2
    //   213: invokevirtual 618	java/io/BufferedInputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_1
    //   219: new 139	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   226: astore_2
    //   227: aload_2
    //   228: ldc_w 620
    //   231: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload_1
    //   237: invokevirtual 520	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 126
    //   246: iconst_1
    //   247: aload_2
    //   248: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_2
    //   259: aload_2
    //   260: astore_1
    //   261: new 139	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   268: astore 4
    //   270: aload_2
    //   271: astore_1
    //   272: aload 4
    //   274: ldc_w 623
    //   277: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: astore_1
    //   283: aload 4
    //   285: aload_3
    //   286: invokevirtual 520	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   289: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_2
    //   294: astore_1
    //   295: ldc 126
    //   297: iconst_1
    //   298: aload 4
    //   300: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_2
    //   307: ifnull +45 -> 352
    //   310: aload_2
    //   311: invokevirtual 618	java/io/BufferedInputStream:close	()V
    //   314: aconst_null
    //   315: areturn
    //   316: astore_1
    //   317: new 139	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   324: astore_2
    //   325: aload_2
    //   326: ldc_w 620
    //   329: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_2
    //   334: aload_1
    //   335: invokevirtual 520	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 126
    //   344: iconst_1
    //   345: aload_2
    //   346: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_2
    //   355: aload_1
    //   356: ifnull +46 -> 402
    //   359: aload_1
    //   360: invokevirtual 618	java/io/BufferedInputStream:close	()V
    //   363: goto +39 -> 402
    //   366: astore_1
    //   367: new 139	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: ldc_w 620
    //   379: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_3
    //   384: aload_1
    //   385: invokevirtual 520	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 126
    //   394: iconst_1
    //   395: aload_3
    //   396: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_2
    //   403: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	RedTouchTextView
    //   0	404	1	paramFile	java.io.File
    //   35	101	2	localObject1	Object
    //   152	1	2	localObject2	Object
    //   160	186	2	localStringBuilder1	StringBuilder
    //   354	49	2	localObject3	Object
    //   10	133	3	localObject4	Object
    //   144	1	3	localError1	java.lang.Error
    //   148	1	3	localException1	Exception
    //   158	30	3	localError2	java.lang.Error
    //   256	30	3	localException2	Exception
    //   374	22	3	localStringBuilder2	StringBuilder
    //   18	281	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   100	104	106	java/lang/Exception
    //   38	45	144	java/lang/Error
    //   47	76	144	java/lang/Error
    //   78	100	144	java/lang/Error
    //   38	45	148	java/lang/Exception
    //   47	76	148	java/lang/Exception
    //   78	100	148	java/lang/Exception
    //   6	36	152	finally
    //   6	36	158	java/lang/Error
    //   212	216	218	java/lang/Exception
    //   6	36	256	java/lang/Exception
    //   310	314	316	java/lang/Exception
    //   38	45	354	finally
    //   47	76	354	finally
    //   78	100	354	finally
    //   163	172	354	finally
    //   174	183	354	finally
    //   185	195	354	finally
    //   197	208	354	finally
    //   261	270	354	finally
    //   272	281	354	finally
    //   283	293	354	finally
    //   295	306	354	finally
    //   359	363	366	java/lang/Exception
  }
  
  public void a()
  {
    if (this.q == null) {
      this.q = new Handler(Looper.getMainLooper());
    }
    Drawable localDrawable = this.b;
    if ((localDrawable != null) && (this.i)) {
      this.g = ((int)(this.h * (localDrawable.getIntrinsicWidth() / this.b.getIntrinsicHeight())));
    }
    this.q.post(new RedTouchTextView.2(this));
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfo()
  {
    return this.m;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.b = paramDrawable;
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "setAppInfo appInfo is null");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAppInfo path = ");
      ((StringBuilder)localObject).append(paramAppInfo.path.get());
      ((StringBuilder)localObject).append("; inewflag = ");
      ((StringBuilder)localObject).append(paramAppInfo.iNewFlag.get());
      QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(a(paramAppInfo), this.n))
    {
      this.a = null;
      this.b = null;
    }
    this.m = paramAppInfo;
    if ((paramAppInfo.red_display_info != null) && (paramAppInfo.red_display_info.red_type_info != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
      int i1 = paramAppInfo.size() - 1;
      while (i1 >= 0)
      {
        localObject = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i1);
        if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 15)
        {
          localObject = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get();
          this.c = ((IRedTouchTextViewApi)QRoute.api(IRedTouchTextViewApi.class)).getApngURLDrawable((String)localObject);
        }
        i1 -= 1;
      }
    }
    invalidate();
  }
  
  public void setIsNeedRedImageAutoFix(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setShowRedInfo(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    this.n = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */