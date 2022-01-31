package com.tencent.mobileqq.redtouch;

import ahkj;
import ahkk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchTextView
  extends TextView
{
  private int jdField_a_of_type_Int = a(30);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public String a;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = a(9);
  public Drawable b;
  private String jdField_b_of_type_JavaLangString = "";
  private int c = a(9);
  private int d = a(4);
  private int e = 100;
  
  public RedTouchTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private int a()
  {
    String str = getText().toString();
    TextPaint localTextPaint = getPaint();
    localTextPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    float f = Layout.getDesiredWidth(str, localTextPaint);
    return (int)(getWidth() - f - getPaddingLeft() - a(0) - a(0));
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (paramRedTypeInfo == null)
    {
      j = i;
      return j;
    }
    int k = paramRedTypeInfo.red_type.get();
    i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoWidth type = " + k + ",width = " + i);
      return i;
      i = this.jdField_b_of_type_Int;
      continue;
      if (a(paramRedTypeInfo, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))
      {
        i = this.jdField_a_of_type_Int + this.d;
      }
      else
      {
        i = this.jdField_a_of_type_Int;
        continue;
        paramRedTypeInfo = paramRedTypeInfo.red_content.get();
        try
        {
          i = Integer.valueOf(paramRedTypeInfo).intValue();
        }
        catch (Exception paramRedTypeInfo)
        {
          QLog.e("RedTouchTextView", 1, "getRedTypeInfoWidth exception e = ", paramRedTypeInfo);
          i = j;
        }
        continue;
        this.jdField_b_of_type_JavaLangString = paramRedTypeInfo.red_content.get();
        paramRedTypeInfo = new TextPaint();
        paramRedTypeInfo.setTextSize(a(11));
        j = (int)paramRedTypeInfo.measureText(this.jdField_b_of_type_JavaLangString);
        i = j;
        if (paramBoolean) {
          i = j + a(6) * 2;
        }
      }
    }
  }
  
  private int a(List paramList)
  {
    int j = 0;
    boolean bool;
    if (paramList != null) {
      if (paramList.size() <= 2) {
        bool = true;
      }
    }
    for (;;)
    {
      int i;
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (j < paramList.size())
          {
            int k = a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(j), bool);
            j += 1;
            i = k + i;
            continue;
            bool = false;
            break;
          }
        }
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoList size = " + paramList.size());
        }
      }
      for (j = i;; j = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoList width = " + j);
        }
        return j;
      }
      bool = false;
    }
  }
  
  private int a(List paramList, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    boolean bool;
    if (paramList != null) {
      if (paramList.size() <= 2) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((paramList != null) && ((paramInt > paramList.size() - 1) || (paramInt < 0)))
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition error, size = " + paramList.size() + " position = " + paramInt);
          j = i;
        }
      }
      do
      {
        return j;
        bool = false;
        break;
        i = k;
        if (paramList != null)
        {
          i = k;
          if (paramList.size() > 0)
          {
            i = paramList.size() - 1;
            while (i >= paramInt)
            {
              j += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i), bool);
              i -= 1;
            }
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition size = " + paramList.size());
              i = j;
            }
          }
        }
        j = i;
      } while (!QLog.isColorLevel());
      QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition width = " + i);
      return i;
      bool = false;
    }
  }
  
  private List a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      paramAppInfo = null;
    }
    List localList;
    do
    {
      return paramAppInfo;
      paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
      if (paramAppInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
        }
        return null;
      }
      localList = paramAppInfo.red_type_info.get();
      if (localList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null");
        }
        return null;
      }
      paramAppInfo = localList;
    } while (localList.size() >= 2);
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2");
    }
    return null;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "drawRed start draw");
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1)) {
        break label50;
      }
      QLog.e("RedTouchTextView", 1, "drawRed showRedInfo = null");
    }
    for (;;)
    {
      return;
      label50:
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        int n = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
        try
        {
          Object localObject1;
          int j;
          int k;
          if (TextUtils.isEmpty(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get()))
          {
            localObject1 = new JSONObject();
            if (n != 0) {
              break label1120;
            }
            if (QLog.isColorLevel()) {
              QLog.d("RedTouchTextView", 2, "draw redtouchpoint");
            }
            j = getWidth() - a(this.jdField_a_of_type_JavaUtilList, i) - a(0);
            k = getHeight() / 2 - this.jdField_b_of_type_Int / 2;
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846133);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, k, this.jdField_b_of_type_Int + j, this.jdField_b_of_type_Int + k);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          }
          for (;;)
          {
            label223:
            if (QLog.isColorLevel()) {
              QLog.d("RedTouchTextView", 2, "draw redtouch text");
            }
            label263:
            label288:
            Object localObject3;
            int i1;
            int m;
            if (((JSONObject)localObject1).has("cr"))
            {
              j = a(((JSONObject)localObject1).getString("cr"));
              if (((JSONObject)localObject1).has("cn"))
              {
                k = a(((JSONObject)localObject1).getString("cn"));
                localObject3 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get();
                Paint localPaint = new Paint(1);
                localPaint.setTextSize(a(11));
                localPaint.setTextAlign(Paint.Align.LEFT);
                i1 = (int)localPaint.measureText((String)localObject3);
                Object localObject4 = localPaint.getFontMetrics();
                int i2 = (int)(((Paint.FontMetrics)localObject4).bottom - ((Paint.FontMetrics)localObject4).top);
                m = getWidth() - a(0) - a(this.jdField_a_of_type_JavaUtilList, i);
                int i3 = getHeight() / 2 - i2 / 2 - a(2);
                Rect localRect = new Rect();
                localRect.left = m;
                localRect.top = i3;
                localRect.right = (i1 + m);
                if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
                  localRect.right += a(6) * 2;
                }
                localRect.bottom = (i3 + i2 + a(2) * 2);
                float f1 = a(2) + i3;
                float f2 = ((Paint.FontMetrics)localObject4).top;
                if (k != 0)
                {
                  localObject4 = getResources().getDrawable(2130846137);
                  ((Drawable)localObject4).getBounds();
                  ((Drawable)localObject4).setBounds(m, i3, localRect.right, localRect.bottom);
                  ((Drawable)localObject4).draw(paramCanvas);
                }
                localPaint.setColor(j);
                j = m;
                if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
                  j = m + a(6);
                }
                paramCanvas.drawText((String)localObject3, j, f1 - f2, localPaint);
              }
            }
            label1120:
            do
            {
              if (n != 3) {
                break label1135;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "draw redtouch img");
              }
              n = getWidth() - a(this.jdField_a_of_type_JavaUtilList, i) - a(0);
              i1 = getHeight() / 2 - this.jdField_a_of_type_Int / 2;
              j = 0;
              k = 0;
              m = 0;
              if (((JSONObject)localObject1).has("av")) {
                j = ((JSONObject)localObject1).getInt("av");
              }
              if (((JSONObject)localObject1).has("dot")) {
                k = ((JSONObject)localObject1).getInt("dot");
              }
              if (((JSONObject)localObject1).has("st")) {
                m = Integer.valueOf(((JSONObject)localObject1).getString("st")).intValue();
              }
              localObject1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get();
              if (m == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("RedTouchTextView", 2, "draw redtouch img gif ");
                }
                localObject2 = getResources().getDrawable(2130839147);
                localObject3 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
                ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
                ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
                ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
                ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
                localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
                ((URLDrawable)localObject1).setCallback(this);
                ((URLDrawable)localObject1).draw(paramCanvas);
                if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
                  break label1135;
                }
                this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, i1, this.jdField_a_of_type_Int + n, this.jdField_a_of_type_Int + i1);
                this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
                break label1135;
                localObject1 = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get());
                break;
              }
              if (m != 0) {
                break label1135;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "draw redtouch img static ");
              }
              if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
              {
                localObject2 = getResources().getDrawable(2130839147);
                ((Drawable)localObject2).setBounds(n, i1, this.jdField_a_of_type_Int + n, this.jdField_a_of_type_Int + i1);
                ((Drawable)localObject2).draw(paramCanvas);
              }
              for (;;)
              {
                if (k == 1)
                {
                  localObject2 = getResources().getDrawable(2130846133);
                  ((Drawable)localObject2).setBounds(getWidth() - a(0) - a(9), i1 - a(4), getWidth() - a(0), i1 + a(5));
                  ((Drawable)localObject2).draw(paramCanvas);
                }
                if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
                  break;
                }
                ThreadManager.post(new ahkj(this, (String)localObject1, j), 8, null, true);
                break;
                this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, i1, this.jdField_a_of_type_Int + n, this.jdField_a_of_type_Int + i1);
                this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
              }
              k = 0;
              break label288;
              j = -1;
              break label263;
              if (n == 4) {
                break label223;
              }
            } while (n != 5);
          }
        }
        catch (Exception localException)
        {
          label1135:
          break label1135;
        }
        i -= 1;
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
      QLog.d("RedTouchTextView", 1, "isSupportRedTouch appinfo = null");
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 1)
          {
            QLog.d("RedTouchTextView", 1, "isSupportRedTouch inewflag = 0, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path);
            return false;
          }
          localObject1 = (BusinessInfoCheckUpdate.RedDisplayInfo)this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.red_display_info.get();
          if (localObject1 != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get());
        return false;
        localObject1 = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject1).red_type_info.get();
        if (localObject1 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get());
      return false;
      if (((List)localObject1).size() >= 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get());
    return false;
    Object localObject1 = new ArrayList((Collection)localObject1);
    int j = a((List)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    int i = 0;
    label270:
    if (((Iterator)localObject2).hasNext())
    {
      if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject2).next()).red_type.get() == 9) {
        break label698;
      }
      i += 1;
    }
    label698:
    for (;;)
    {
      break label270;
      if (i == 0)
      {
        QLog.e("RedTouchTextView", 1, "isSupportRedTouch notSpaceInfoCount = 0");
        return false;
      }
      int i1 = a();
      int k = j;
      if ((k > i1) && (i > 1))
      {
        int n = ((List)localObject1).size();
        int m = 0;
        label354:
        k = n;
        j = i;
        if (m < n)
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(m)).red_type.get() != 9)
          {
            ((List)localObject1).remove(m);
            j = i - 1;
            k = n - 1;
          }
        }
        else {
          i = 0;
        }
        for (;;)
        {
          if (i < k - 1)
          {
            if ((((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(i)).red_type.get() == 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(i + 1)).red_type.get() == 9)) {
              ((List)localObject1).remove(i);
            }
          }
          else
          {
            k = a((List)localObject1);
            i = j;
            break;
            m += 1;
            break label354;
          }
          i += 1;
        }
      }
      if ((k > i1) && (i == 1))
      {
        j = 0;
        while (j < ((List)localObject1).size())
        {
          localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(j);
          if ((((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() == 3) && (a((BusinessInfoCheckUpdate.RedTypeInfo)localObject2, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))) {
            setImageRedNotShowRedPoint((BusinessInfoCheckUpdate.RedTypeInfo)localObject2, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
          }
          j += 1;
        }
      }
      if ((a((List)localObject1) > i1) && (i == 1))
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(i);
          if ((((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() != 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() != 0))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
            ((List)localObject1).set(i, localObject2);
          }
          i += 1;
        }
      }
      if (a((List)localObject1) > i1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      return true;
    }
  }
  
  public static boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool = true;
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 3))
    {
      bool = false;
      return bool;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
            continue;
          }
          paramRedTypeInfo = new JSONObject();
          if (!paramRedTypeInfo.has("dot")) {
            continue;
          }
          i = paramRedTypeInfo.getInt("dot");
        }
        catch (Exception paramRedTypeInfo)
        {
          int i = 0;
          QLog.e("RedTouchTextView", 1, "isSupportRedTouch json exception e = " + paramRedTypeInfo.getMessage());
          int j = i;
          continue;
          i = 0;
          continue;
        }
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RedTouchTextView", 2, "isSupportRedTouch had dot = " + i + ",path = " + paramAppInfo.path.get());
            j = i;
          }
          if (j == 1) {
            break;
          }
          return false;
        }
        catch (Exception paramRedTypeInfo) {}
      }
      paramRedTypeInfo = new JSONObject(paramRedTypeInfo.red_desc.get());
    }
  }
  
  private boolean a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {}
    while ((paramList1.size() != paramList2.size()) || (paramList1.size() == 0)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label159;
      }
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList1.get(i);
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList2.get(i);
      if ((localRedTypeInfo1.red_type.get() != localRedTypeInfo2.red_type.get()) || (!localRedTypeInfo1.red_content.get().equals(localRedTypeInfo2.red_content.get())) || (!localRedTypeInfo1.red_desc.get().equals(localRedTypeInfo2.red_desc.get())) || (localRedTypeInfo1.red_priority.get() != localRedTypeInfo2.red_priority.get())) {
        break;
      }
      i += 1;
    }
    label159:
    return true;
  }
  
  public static void setImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 3)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get()))
        {
          localJSONObject = new JSONObject();
          if (localJSONObject.has("dot")) {
            localJSONObject.put("dot", 0);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RedTouchTextView", 2, "setImageRedNotShowRedPoint ,path = " + paramAppInfo.path.get());
          }
          paramRedTypeInfo.red_desc.set(localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramRedTypeInfo)
      {
        QLog.e("RedTouchTextView", 1, "setImageRedNotShowRedPoint json exception e = " + paramRedTypeInfo.getMessage());
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get());
    }
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
  }
  
  public Bitmap a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile.getAbsolutePath());
      Bitmap localBitmap = SafeBitmapFactory.decodeStream(new BufferedInputStream(paramFile));
      paramFile.close();
      return localBitmap;
    }
    catch (Exception paramFile)
    {
      QLog.e("RedTouchTextView", 1, "getIconFromFile exception e = " + paramFile.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ahkk(this));
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
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
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "setAppInfo path = " + paramAppInfo.path.get() + "; inewflag = " + paramAppInfo.iNewFlag.get());
    }
    if (!a(a(paramAppInfo), this.jdField_a_of_type_JavaUtilList))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */