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
import benf;
import beng;
import benh;
import beni;
import benj;
import benk;
import beno;
import benp;
import benr;
import bens;
import bent;
import benx;
import beny;
import beoc;
import beof;
import beol;
import beoo;
import beoq;
import beow;
import bepc;
import bepe;
import bjmm;
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
  private beng jdField_a_of_type_Beng;
  private benh jdField_a_of_type_Benh;
  private beni jdField_a_of_type_Beni;
  public benk a;
  private benx jdField_a_of_type_Benx;
  beol jdField_a_of_type_Beol = new benf(this);
  private beoo jdField_a_of_type_Beoo;
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
    addItemDecoration(new benj(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Beoo = new beoo(this, paramContext);
    this.jdField_a_of_type_Beoo.a(this.jdField_a_of_type_Beol);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Beoo);
    paramAttributeSet.put(0, new beow(this, paramContext).a(this.jdField_a_of_type_Beol));
    paramAttributeSet.put(3, new beof(this, paramContext).a(this.jdField_a_of_type_Beol));
    paramAttributeSet.put(1, new beoq(this).a(this.jdField_a_of_type_Beol));
    paramAttributeSet.put(2, new bepe(this).a(this.jdField_a_of_type_Beol));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Beol));
    paramAttributeSet.put(7, new beoc(this, paramContext).a(this.jdField_a_of_type_Beol));
    this.jdField_a_of_type_Benk = new benk(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Benk);
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
    for (int j = 0; i < this.jdField_a_of_type_Benk.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Benk.a(i) != null)
      {
        k = j;
        if (this.jdField_a_of_type_Benk.a(i).b() == paramInt) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Benk.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<beny> a()
  {
    return this.jdField_a_of_type_Benk.a();
  }
  
  public ArrayList<beno> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Benk.getItemCount())
    {
      if ((this.jdField_a_of_type_Benk.a(i) != null) && (this.jdField_a_of_type_Benk.a(i).b() == paramInt)) {
        localArrayList.add(this.jdField_a_of_type_Benk.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
    bepc localbepc = (bepc)findViewHolderForAdapterPosition(this.jdField_a_of_type_Benx.jdField_c_of_type_Int);
    if (localbepc != null)
    {
      localbepc.a.setFocusable(true);
      localbepc.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbepc));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Benk.b(0);
      this.jdField_a_of_type_Benk.notifyDataSetChanged();
      this.jdField_a_of_type_Beol.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Benk.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Benk.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Benk.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof benx))
        {
          if (this.jdField_a_of_type_Benx != null) {
            this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Benx = ((benx)localObject2);
          this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Benk.b(paramInt);
        this.jdField_a_of_type_Benk.notifyDataSetChanged();
        this.jdField_a_of_type_Beol.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof benx)) || (!(localObject2 instanceof benx)))
      {
        this.jdField_a_of_type_Benk.b(paramInt);
        this.jdField_a_of_type_Benk.notifyDataSetChanged();
        this.jdField_a_of_type_Beol.a(null, false);
        return;
      }
      localObject1 = (benx)localObject1;
      localObject2 = (benx)localObject2;
      ((benx)localObject2).jdField_a_of_type_Int = ((benx)localObject2).jdField_a_of_type_JavaLangString.length();
      bepc localbepc = (bepc)findViewHolderForAdapterPosition(((benx)localObject2).jdField_c_of_type_Int);
      if (localbepc != null) {
        localbepc.a.setSelection(((benx)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((benx)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Benx != null) {
          this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Benx = ((benx)localObject2);
        this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Benk.b(paramInt + 1);
        this.jdField_a_of_type_Benk.b(paramInt);
        this.jdField_a_of_type_Benk.notifyDataSetChanged();
        this.jdField_a_of_type_Beol.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((benx)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((benx)localObject2).jdField_a_of_type_JavaLangString = ((benx)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((benx)localObject2).jdField_a_of_type_JavaLangString += ((benx)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Benk.a(paramInt, paramString);
    this.jdField_a_of_type_Beol.a(null, false);
  }
  
  public void a(beno parambeno)
  {
    if (parambeno == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Benk.getItemCount() == 0)
    {
      if ((parambeno instanceof benx))
      {
        this.jdField_a_of_type_Benk.a(parambeno);
        this.jdField_a_of_type_Benk.notifyDataSetChanged();
        this.jdField_a_of_type_Benx = ((benx)parambeno);
        this.jdField_a_of_type_Benx.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new benx("");
      localObject2 = new benx("");
      this.jdField_a_of_type_Benk.a((beno)localObject1);
      this.jdField_a_of_type_Benk.a(parambeno);
      this.jdField_a_of_type_Benk.a((beno)localObject2);
      this.jdField_a_of_type_Benx = ((benx)localObject2);
      this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Benx.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Benk.notifyDataSetChanged();
      this.jdField_a_of_type_Beol.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Benx.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Benx == null)
    {
      localObject1 = this.jdField_a_of_type_Benk.a(this.jdField_a_of_type_Benk.getItemCount() - 1);
      if ((localObject1 instanceof benx))
      {
        this.jdField_a_of_type_Benx = ((benx)localObject1);
        this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Benx.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Benx.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Benx.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Benx.jdField_a_of_type_Int;
      localObject1 = (bepc)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bepc)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Benx.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambeno instanceof benx)) {
          break label519;
        }
        parambeno = (benx)parambeno;
        this.jdField_a_of_type_Benx.b((String)localObject2 + parambeno.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Benx;
        ((benx)localObject1).jdField_a_of_type_Int += parambeno.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Benx.jdField_c_of_type_Int);
        this.jdField_a_of_type_Beol.a(null, false);
        return;
        localObject1 = new benx("");
        this.jdField_a_of_type_Benx = ((benx)localObject1);
        this.jdField_a_of_type_Benx.jdField_c_of_type_Int = this.jdField_a_of_type_Benk.getItemCount();
        this.jdField_a_of_type_Benk.a((beno)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Benx.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Benx.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Benx.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Benx.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      beno localbeno = this.jdField_a_of_type_Benk.a(j);
      if ((localbeno instanceof benx)) {
        ((benx)localbeno).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new benx((String)localObject1);
        this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = false;
        ((benx)localObject1).jdField_a_of_type_Boolean = true;
        ((benx)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Benx = ((benx)localObject1);
        this.jdField_a_of_type_Benk.a(j + 1, (beno)localObject1);
        this.jdField_a_of_type_Benk.a(j + 1, parambeno);
        this.jdField_a_of_type_Benx.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Benk.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<beny> paramArrayList)
  {
    this.jdField_a_of_type_Benk.a(paramArrayList);
  }
  
  public void a(List<beno> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((beno)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Benk.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<bens> b()
  {
    return this.jdField_a_of_type_Benk.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = false;
    bepc localbepc = (bepc)findViewHolderForAdapterPosition(this.jdField_a_of_type_Benx.jdField_c_of_type_Int);
    if (localbepc != null)
    {
      localbepc.a.setFocusable(false);
      localbepc.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbepc));
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
    return this.jdField_a_of_type_Benk.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Beoo.a(null);
    if (this.jdField_a_of_type_Benk.b())
    {
      this.jdField_a_of_type_Benk.b(0);
      this.jdField_a_of_type_Benk.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Benk.a();
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
          bjmm.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(beng parambeng)
  {
    this.jdField_a_of_type_Beng = parambeng;
  }
  
  public void setContentLengthChangeListener(benh parambenh)
  {
    this.jdField_a_of_type_Benh = parambenh;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Benk.a(new JSONArray(paramString));
      this.jdField_a_of_type_Beol.a(null, false);
      int i = this.jdField_a_of_type_Benk.b();
      this.jdField_a_of_type_Beol.a(this.jdField_a_of_type_Int, i);
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
          beno localbeno = benp.a(paramJSONArray.getJSONObject(i));
          if (localbeno == null) {
            break label201;
          }
          if ((localbeno instanceof beny))
          {
            ((beny)localbeno).g = 3;
            if ((localbeno instanceof bent)) {
              ((bent)localbeno).e = 100;
            }
          }
          if ((localbeno instanceof benx))
          {
            this.jdField_a_of_type_Benx.b(((benx)localbeno).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Benx.jdField_a_of_type_Int = ((benx)localbeno).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Benk.notifyDataSetChanged();
          }
          else
          {
            a(localbeno);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Benk.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Benk.a(i);
          if ((paramJSONArray instanceof benx))
          {
            this.jdField_a_of_type_Benx = ((benx)paramJSONArray);
            this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Benk.notifyDataSetChanged();
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
    setData("[" + new benx("").toString() + "]");
    this.jdField_a_of_type_Benx = ((benx)this.jdField_a_of_type_Benk.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(beni parambeni)
  {
    this.jdField_a_of_type_Beni = parambeni;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Beoo.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Benk.b())
    {
      this.jdField_a_of_type_Benk.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Benk.a(0, new benr());
    this.jdField_a_of_type_Benk.notifyDataSetChanged();
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
    this.jdField_a_of_type_Benk.a(paramInt);
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