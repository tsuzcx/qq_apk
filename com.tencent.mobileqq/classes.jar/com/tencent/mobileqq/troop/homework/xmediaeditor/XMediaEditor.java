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
import baaj;
import baak;
import baal;
import baam;
import baan;
import baao;
import baas;
import baat;
import baav;
import baaw;
import baax;
import babb;
import babc;
import babg;
import babj;
import babp;
import babs;
import babu;
import baca;
import bacg;
import baci;
import bfmr;
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
  private baak jdField_a_of_type_Baak;
  private baal jdField_a_of_type_Baal;
  private baam jdField_a_of_type_Baam;
  public baao a;
  private babb jdField_a_of_type_Babb;
  babp jdField_a_of_type_Babp = new baaj(this);
  private babs jdField_a_of_type_Babs;
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
    addItemDecoration(new baan(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Babs = new babs(this, paramContext);
    this.jdField_a_of_type_Babs.a(this.jdField_a_of_type_Babp);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Babs);
    paramAttributeSet.put(0, new baca(this, paramContext).a(this.jdField_a_of_type_Babp));
    paramAttributeSet.put(3, new babj(this, paramContext).a(this.jdField_a_of_type_Babp));
    paramAttributeSet.put(1, new babu(this).a(this.jdField_a_of_type_Babp));
    paramAttributeSet.put(2, new baci(this).a(this.jdField_a_of_type_Babp));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Babp));
    paramAttributeSet.put(7, new babg(this, paramContext).a(this.jdField_a_of_type_Babp));
    this.jdField_a_of_type_Baao = new baao(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Baao);
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
    for (int j = 0; i < this.jdField_a_of_type_Baao.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Baao.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Baao.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<babc> a()
  {
    return this.jdField_a_of_type_Baao.a();
  }
  
  public ArrayList<baas> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Baao.getItemCount())
    {
      if (this.jdField_a_of_type_Baao.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Baao.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
    bacg localbacg = (bacg)findViewHolderForAdapterPosition(this.jdField_a_of_type_Babb.jdField_c_of_type_Int);
    if (localbacg != null)
    {
      localbacg.a.setFocusable(true);
      localbacg.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbacg));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Baao.b(0);
      this.jdField_a_of_type_Baao.notifyDataSetChanged();
      this.jdField_a_of_type_Babp.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Baao.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Baao.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Baao.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof babb))
        {
          if (this.jdField_a_of_type_Babb != null) {
            this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Babb = ((babb)localObject2);
          this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Baao.b(paramInt);
        this.jdField_a_of_type_Baao.notifyDataSetChanged();
        this.jdField_a_of_type_Babp.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof babb)) || (!(localObject2 instanceof babb)))
      {
        this.jdField_a_of_type_Baao.b(paramInt);
        this.jdField_a_of_type_Baao.notifyDataSetChanged();
        this.jdField_a_of_type_Babp.a(null, false);
        return;
      }
      localObject1 = (babb)localObject1;
      localObject2 = (babb)localObject2;
      ((babb)localObject2).jdField_a_of_type_Int = ((babb)localObject2).jdField_a_of_type_JavaLangString.length();
      bacg localbacg = (bacg)findViewHolderForAdapterPosition(((babb)localObject2).jdField_c_of_type_Int);
      if (localbacg != null) {
        localbacg.a.setSelection(((babb)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((babb)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Babb != null) {
          this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Babb = ((babb)localObject2);
        this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Baao.b(paramInt + 1);
        this.jdField_a_of_type_Baao.b(paramInt);
        this.jdField_a_of_type_Baao.notifyDataSetChanged();
        this.jdField_a_of_type_Babp.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((babb)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((babb)localObject2).jdField_a_of_type_JavaLangString = ((babb)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((babb)localObject2).jdField_a_of_type_JavaLangString += ((babb)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Baao.a(paramInt, paramString);
    this.jdField_a_of_type_Babp.a(null, false);
  }
  
  public void a(baas parambaas)
  {
    if (parambaas == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Baao.getItemCount() == 0)
    {
      if ((parambaas instanceof babb))
      {
        this.jdField_a_of_type_Baao.a(parambaas);
        this.jdField_a_of_type_Baao.notifyDataSetChanged();
        this.jdField_a_of_type_Babb = ((babb)parambaas);
        this.jdField_a_of_type_Babb.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new babb("");
      localObject2 = new babb("");
      this.jdField_a_of_type_Baao.a((baas)localObject1);
      this.jdField_a_of_type_Baao.a(parambaas);
      this.jdField_a_of_type_Baao.a((baas)localObject2);
      this.jdField_a_of_type_Babb = ((babb)localObject2);
      this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Babb.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Baao.notifyDataSetChanged();
      this.jdField_a_of_type_Babp.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Babb.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Babb == null)
    {
      localObject1 = this.jdField_a_of_type_Baao.a(this.jdField_a_of_type_Baao.getItemCount() - 1);
      if ((localObject1 instanceof babb))
      {
        this.jdField_a_of_type_Babb = ((babb)localObject1);
        this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Babb.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Babb.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Babb.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Babb.jdField_a_of_type_Int;
      localObject1 = (bacg)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bacg)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambaas instanceof babb)) {
          break label519;
        }
        parambaas = (babb)parambaas;
        this.jdField_a_of_type_Babb.b((String)localObject2 + parambaas.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Babb;
        ((babb)localObject1).jdField_a_of_type_Int += parambaas.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Babb.jdField_c_of_type_Int);
        this.jdField_a_of_type_Babp.a(null, false);
        return;
        localObject1 = new babb("");
        this.jdField_a_of_type_Babb = ((babb)localObject1);
        this.jdField_a_of_type_Babb.jdField_c_of_type_Int = this.jdField_a_of_type_Baao.getItemCount();
        this.jdField_a_of_type_Baao.a((baas)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      baas localbaas = this.jdField_a_of_type_Baao.a(j);
      if ((localbaas instanceof babb)) {
        ((babb)localbaas).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new babb((String)localObject1);
        this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = false;
        ((babb)localObject1).jdField_a_of_type_Boolean = true;
        ((babb)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Babb = ((babb)localObject1);
        this.jdField_a_of_type_Baao.a(j + 1, (baas)localObject1);
        this.jdField_a_of_type_Baao.a(j + 1, parambaas);
        this.jdField_a_of_type_Babb.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Baao.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<babc> paramArrayList)
  {
    this.jdField_a_of_type_Baao.a(paramArrayList);
  }
  
  public void a(List<baas> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((baas)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Baao.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<baaw> b()
  {
    return this.jdField_a_of_type_Baao.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = false;
    bacg localbacg = (bacg)findViewHolderForAdapterPosition(this.jdField_a_of_type_Babb.jdField_c_of_type_Int);
    if (localbacg != null)
    {
      localbacg.a.setFocusable(false);
      localbacg.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbacg));
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
    return this.jdField_a_of_type_Baao.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Babs.a(null);
    if (this.jdField_a_of_type_Baao.b())
    {
      this.jdField_a_of_type_Baao.b(0);
      this.jdField_a_of_type_Baao.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Baao.a();
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
          bfmr.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(baak parambaak)
  {
    this.jdField_a_of_type_Baak = parambaak;
  }
  
  public void setContentLengthChangeListener(baal parambaal)
  {
    this.jdField_a_of_type_Baal = parambaal;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Baao.a(new JSONArray(paramString));
      this.jdField_a_of_type_Babp.a(null, false);
      int i = this.jdField_a_of_type_Baao.b();
      this.jdField_a_of_type_Babp.a(this.jdField_a_of_type_Int, i);
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
          baas localbaas = baat.a(paramJSONArray.getJSONObject(i));
          if (localbaas == null) {
            break label201;
          }
          if ((localbaas instanceof babc))
          {
            ((babc)localbaas).g = 3;
            if ((localbaas instanceof baax)) {
              ((baax)localbaas).e = 100;
            }
          }
          if ((localbaas instanceof babb))
          {
            this.jdField_a_of_type_Babb.b(((babb)localbaas).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Babb.jdField_a_of_type_Int = ((babb)localbaas).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Baao.notifyDataSetChanged();
          }
          else
          {
            a(localbaas);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Baao.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Baao.a(i);
          if ((paramJSONArray instanceof babb))
          {
            this.jdField_a_of_type_Babb = ((babb)paramJSONArray);
            this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Baao.notifyDataSetChanged();
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
    setData("[" + new babb("").toString() + "]");
    this.jdField_a_of_type_Babb = ((babb)this.jdField_a_of_type_Baao.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(baam parambaam)
  {
    this.jdField_a_of_type_Baam = parambaam;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Babs.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Baao.b())
    {
      this.jdField_a_of_type_Baao.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Baao.a(0, new baav());
    this.jdField_a_of_type_Baao.notifyDataSetChanged();
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
    this.jdField_a_of_type_Baao.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */