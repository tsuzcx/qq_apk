package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import bfui;
import bfuj;
import bfuk;
import bful;
import bfum;
import bfun;
import bfur;
import bfus;
import bfuu;
import bfuv;
import bfuw;
import bfva;
import bfvb;
import bfvf;
import bfvi;
import bfvo;
import bfvr;
import bfvt;
import bfvz;
import bfwf;
import bfwh;
import bkxz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditor
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private View jdField_a_of_type_AndroidViewView;
  private bfuj jdField_a_of_type_Bfuj;
  private bfuk jdField_a_of_type_Bfuk;
  private bful jdField_a_of_type_Bful;
  public bfun a;
  private bfva jdField_a_of_type_Bfva;
  bfvo jdField_a_of_type_Bfvo = new bfui(this);
  private bfvr jdField_a_of_type_Bfvr;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public XMediaEditor(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new LinearLayoutManager(paramContext);
    addItemDecoration(new bfum(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Bfvr = new bfvr(this, paramContext);
    this.jdField_a_of_type_Bfvr.a(this.jdField_a_of_type_Bfvo);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Bfvr);
    paramAttributeSet.put(0, new bfvz(this, paramContext).a(this.jdField_a_of_type_Bfvo));
    paramAttributeSet.put(3, new bfvi(this, paramContext).a(this.jdField_a_of_type_Bfvo));
    paramAttributeSet.put(1, new bfvt(this).a(this.jdField_a_of_type_Bfvo));
    paramAttributeSet.put(2, new bfwh(this).a(this.jdField_a_of_type_Bfvo));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Bfvo));
    paramAttributeSet.put(7, new bfvf(this, paramContext).a(this.jdField_a_of_type_Bfvo));
    this.jdField_a_of_type_Bfun = new bfun(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Bfun);
    setDefaultContent();
  }
  
  private <T extends View> T a(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return null;
        if (paramClass.isInstance(paramView)) {
          return (View)paramClass.cast(paramView);
        }
      } while (!(paramView instanceof ViewGroup));
      paramView = (ViewGroup)paramView;
      i = paramView.getChildCount();
    } while (i <= 0);
    return a(paramClass, paramView.getChildAt(i - 1));
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_Bfun.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Bfun.a(i) != null)
      {
        k = j;
        if (this.jdField_a_of_type_Bfun.a(i).b() == paramInt) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bfun.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<bfvb> a()
  {
    return this.jdField_a_of_type_Bfun.a();
  }
  
  public ArrayList<bfur> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bfun.getItemCount())
    {
      if ((this.jdField_a_of_type_Bfun.a(i) != null) && (this.jdField_a_of_type_Bfun.a(i).b() == paramInt)) {
        localArrayList.add(this.jdField_a_of_type_Bfun.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
    bfwf localbfwf = (bfwf)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bfva.jdField_c_of_type_Int);
    if (localbfwf != null)
    {
      localbfwf.a.setFocusable(true);
      localbfwf.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbfwf));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Bfun.b(0);
      this.jdField_a_of_type_Bfun.notifyDataSetChanged();
      this.jdField_a_of_type_Bfvo.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Bfun.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Bfun.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Bfun.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof bfva))
        {
          if (this.jdField_a_of_type_Bfva != null) {
            this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Bfva = ((bfva)localObject2);
          this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Bfun.b(paramInt);
        this.jdField_a_of_type_Bfun.notifyDataSetChanged();
        this.jdField_a_of_type_Bfvo.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof bfva)) || (!(localObject2 instanceof bfva)))
      {
        this.jdField_a_of_type_Bfun.b(paramInt);
        this.jdField_a_of_type_Bfun.notifyDataSetChanged();
        this.jdField_a_of_type_Bfvo.a(null, false);
        return;
      }
      localObject1 = (bfva)localObject1;
      localObject2 = (bfva)localObject2;
      ((bfva)localObject2).jdField_a_of_type_Int = ((bfva)localObject2).jdField_a_of_type_JavaLangString.length();
      bfwf localbfwf = (bfwf)findViewHolderForAdapterPosition(((bfva)localObject2).jdField_c_of_type_Int);
      if (localbfwf != null) {
        localbfwf.a.setSelection(((bfva)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((bfva)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Bfva != null) {
          this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Bfva = ((bfva)localObject2);
        this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bfun.b(paramInt + 1);
        this.jdField_a_of_type_Bfun.b(paramInt);
        this.jdField_a_of_type_Bfun.notifyDataSetChanged();
        this.jdField_a_of_type_Bfvo.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((bfva)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((bfva)localObject2).jdField_a_of_type_JavaLangString = ((bfva)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((bfva)localObject2).jdField_a_of_type_JavaLangString += ((bfva)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Bfun.a(paramInt, paramString);
    this.jdField_a_of_type_Bfvo.a(null, false);
  }
  
  public void a(bfur parambfur)
  {
    if (parambfur == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Bfun.getItemCount() == 0)
    {
      if ((parambfur instanceof bfva))
      {
        this.jdField_a_of_type_Bfun.a(parambfur);
        this.jdField_a_of_type_Bfun.notifyDataSetChanged();
        this.jdField_a_of_type_Bfva = ((bfva)parambfur);
        this.jdField_a_of_type_Bfva.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new bfva("");
      localObject2 = new bfva("");
      this.jdField_a_of_type_Bfun.a((bfur)localObject1);
      this.jdField_a_of_type_Bfun.a(parambfur);
      this.jdField_a_of_type_Bfun.a((bfur)localObject2);
      this.jdField_a_of_type_Bfva = ((bfva)localObject2);
      this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bfva.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Bfun.notifyDataSetChanged();
      this.jdField_a_of_type_Bfvo.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Bfva.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Bfva == null)
    {
      localObject1 = this.jdField_a_of_type_Bfun.a(this.jdField_a_of_type_Bfun.getItemCount() - 1);
      if ((localObject1 instanceof bfva))
      {
        this.jdField_a_of_type_Bfva = ((bfva)localObject1);
        this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Bfva.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Bfva.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Bfva.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Bfva.jdField_a_of_type_Int;
      localObject1 = (bfwf)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bfwf)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Bfva.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambfur instanceof bfva)) {
          break label519;
        }
        parambfur = (bfva)parambfur;
        this.jdField_a_of_type_Bfva.b((String)localObject2 + parambfur.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Bfva;
        ((bfva)localObject1).jdField_a_of_type_Int += parambfur.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Bfva.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bfvo.a(null, false);
        return;
        localObject1 = new bfva("");
        this.jdField_a_of_type_Bfva = ((bfva)localObject1);
        this.jdField_a_of_type_Bfva.jdField_c_of_type_Int = this.jdField_a_of_type_Bfun.getItemCount();
        this.jdField_a_of_type_Bfun.a((bfur)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Bfva.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Bfva.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Bfva.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Bfva.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      bfur localbfur = this.jdField_a_of_type_Bfun.a(j);
      if ((localbfur instanceof bfva)) {
        ((bfva)localbfur).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new bfva((String)localObject1);
        this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = false;
        ((bfva)localObject1).jdField_a_of_type_Boolean = true;
        ((bfva)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Bfva = ((bfva)localObject1);
        this.jdField_a_of_type_Bfun.a(j + 1, (bfur)localObject1);
        this.jdField_a_of_type_Bfun.a(j + 1, parambfur);
        this.jdField_a_of_type_Bfva.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Bfun.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<bfvb> paramArrayList)
  {
    this.jdField_a_of_type_Bfun.a(paramArrayList);
  }
  
  public void a(List<bfur> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((bfur)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bfun.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<bfuv> b()
  {
    return this.jdField_a_of_type_Bfun.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = false;
    bfwf localbfwf = (bfwf)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bfva.jdField_c_of_type_Int);
    if (localbfwf != null)
    {
      localbfwf.a.setFocusable(false);
      localbfwf.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbfwf));
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    setDefaultContent();
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return (this.jdField_a_of_type_Boolean) && (super.canScrollVertically(paramInt));
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Bfun.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Bfvr.a(null);
    if (this.jdField_a_of_type_Bfun.b())
    {
      this.jdField_a_of_type_Bfun.b(0);
      this.jdField_a_of_type_Bfun.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Bfun.a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int != 2147483647) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (d() == 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      EditText localEditText = (EditText)a(EditText.class, this);
      if (localEditText != null)
      {
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        float f = paramMotionEvent.getRawY();
        if (arrayOfInt[1] <= f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("XMediaEditor", 2, "Oops! found et");
          }
          if (!localEditText.isFocused())
          {
            localEditText.setFocusable(true);
            localEditText.setFocusableInTouchMode(true);
            localEditText.requestFocus();
          }
          bkxz.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(bfuj parambfuj)
  {
    this.jdField_a_of_type_Bfuj = parambfuj;
  }
  
  public void setContentLengthChangeListener(bfuk parambfuk)
  {
    this.jdField_a_of_type_Bfuk = parambfuk;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bfun.a(new JSONArray(paramString));
      this.jdField_a_of_type_Bfvo.a(null, false);
      int i = this.jdField_a_of_type_Bfun.b();
      this.jdField_a_of_type_Bfvo.a(this.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Int = i;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDataByEdit(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          bfur localbfur = bfus.a(paramJSONArray.getJSONObject(i));
          if (localbfur == null) {
            break label201;
          }
          if ((localbfur instanceof bfvb))
          {
            ((bfvb)localbfur).g = 3;
            if ((localbfur instanceof bfuw)) {
              ((bfuw)localbfur).e = 100;
            }
          }
          if ((localbfur instanceof bfva))
          {
            this.jdField_a_of_type_Bfva.b(((bfva)localbfur).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bfva.jdField_a_of_type_Int = ((bfva)localbfur).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Bfun.notifyDataSetChanged();
          }
          else
          {
            a(localbfur);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Bfun.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Bfun.a(i);
          if ((paramJSONArray instanceof bfva))
          {
            this.jdField_a_of_type_Bfva = ((bfva)paramJSONArray);
            this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Bfun.notifyDataSetChanged();
          scrollToPosition(0);
          return;
        }
        i += 1;
      }
      label201:
      i += 1;
    }
  }
  
  public void setDefaultContent()
  {
    setData("[" + new bfva("").toString() + "]");
    this.jdField_a_of_type_Bfva = ((bfva)this.jdField_a_of_type_Bfun.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(bful parambful)
  {
    this.jdField_a_of_type_Bful = parambful;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bfvr.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Bfun.b())
    {
      this.jdField_a_of_type_Bfun.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Bfun.a(0, new bfuu());
    this.jdField_a_of_type_Bfun.notifyDataSetChanged();
  }
  
  public void setHint(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLeftRightPadding(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShowType(int paramInt)
  {
    this.jdField_a_of_type_Bfun.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */