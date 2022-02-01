package com.tencent.mobileqq.wink.editor.text;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinkEditorTextViewModel
  extends BaseViewModel
{
  static final String a = RFApplication.getApplication().getString(2131886339);
  static final List<Integer> b = Arrays.asList(new Integer[] { Integer.valueOf(Color.parseColor("#EFEFEF")), Integer.valueOf(Color.parseColor("#9F9F9F")), Integer.valueOf(Color.parseColor("#000000")), Integer.valueOf(Color.parseColor("#FF5A4D")), Integer.valueOf(Color.parseColor("#FF9243")), Integer.valueOf(Color.parseColor("#FFEE50")), Integer.valueOf(Color.parseColor("#27AA4C")), Integer.valueOf(Color.parseColor("#70D5FB")), Integer.valueOf(Color.parseColor("#5596FF")), Integer.valueOf(Color.parseColor("#8F5BF6")), Integer.valueOf(Color.parseColor("#FF94B9")) });
  protected List<MetaMaterial> c;
  private final String d = getClass().getSimpleName();
  private final MutableLiveData<String> e = new MutableLiveData();
  private final MutableLiveData<List<MetaMaterial>> f = new MutableLiveData();
  private final MutableLiveData<List<MetaMaterial>> g = new MutableLiveData();
  private final MutableLiveData<MetaMaterial> h = new MutableLiveData();
  private final MutableLiveData<Integer> i = new MutableLiveData();
  private final MutableLiveData<Integer> j = new MutableLiveData();
  private final MutableLiveData<Integer> k = new MutableLiveData();
  private final MutableLiveData<WinkStickerModel> l = new MutableLiveData();
  private final MutableLiveData<MetaMaterial> m = new MutableLiveData();
  private final List<MetaMaterial> n = new ArrayList();
  private final List<MetaMaterial> o = new ArrayList();
  private final List<MetaMaterial> p = new ArrayList();
  private String q;
  private MetaMaterial r;
  private WinkStickerModel s;
  
  private MetaMaterial a(String paramString, List<MetaMaterial> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i1 = b(paramString, paramList);
    if (i1 == -1) {
      return null;
    }
    return (MetaMaterial)paramList.get(i1);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (("CATEGORY_TEXT_PATTERN".equals(paramString1)) || ("CATEGORY_TEXT_DECOR".equals(paramString1))) && ("CATEGORY_TEXT_STYLE".equals(paramString2));
  }
  
  private int b(String paramString, List<MetaMaterial> paramList)
  {
    if ((paramList != null) && (paramString != null))
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (paramString.equals(((MetaMaterial)paramList.get(i1)).id)) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private void b(@NonNull MetaMaterial paramMetaMaterial)
  {
    this.r.id = paramMetaMaterial.id;
    this.r.packageUrl = paramMetaMaterial.packageUrl;
    this.r.packageMd5 = paramMetaMaterial.packageMd5;
    TextMetaMaterialKt.c(this.r, TextMetaMaterialKt.f(paramMetaMaterial));
    TextMetaMaterialKt.d(this.r, TextMetaMaterialKt.g(paramMetaMaterial));
    TextMetaMaterialKt.e(this.r, TextMetaMaterialKt.h(paramMetaMaterial));
    TextMetaMaterialKt.f(this.r, TextMetaMaterialKt.i(paramMetaMaterial));
    String str = e(this.r.id);
    if ((b(str, MetaMaterialKt.d(paramMetaMaterial))) || (c(str, MetaMaterialKt.d(paramMetaMaterial)))) {
      TextMetaMaterialKt.a(this.r, TextMetaMaterialKt.o(paramMetaMaterial));
    }
    if (("CATEGORY_TEXT_PATTERN".equals(MetaMaterialKt.d(paramMetaMaterial))) || ("CATEGORY_TEXT_DECOR".equals(MetaMaterialKt.d(paramMetaMaterial))))
    {
      MetaMaterialKt.b(this.r, MetaMaterialKt.d(paramMetaMaterial));
      TextMetaMaterialKt.h(this.r, TextMetaMaterialKt.n(paramMetaMaterial));
      TextMetaMaterialKt.a(this.r, TextMetaMaterialKt.l(paramMetaMaterial));
      TextMetaMaterialKt.b(this.r, TextMetaMaterialKt.m(paramMetaMaterial));
    }
    this.h.postValue(this.r);
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    return (!"CATEGORY_TEXT_DECOR".equals(paramString1)) || ("CATEGORY_TEXT_DECOR".equals(paramString2));
  }
  
  private void c(String paramString)
  {
    this.r = TextMetaMaterialKt.a();
    this.h.postValue(this.r);
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    return ("CATEGORY_TEXT_DECOR".equals(paramString1)) && (!"CATEGORY_TEXT_DECOR".equals(paramString2));
  }
  
  private String e(String paramString)
  {
    if (a(paramString, this.n) != null) {
      return "CATEGORY_TEXT_STYLE";
    }
    if (a(paramString, this.o) != null) {
      return "CATEGORY_TEXT_PATTERN";
    }
    if (a(paramString, this.p) != null) {
      return "CATEGORY_TEXT_DECOR";
    }
    return null;
  }
  
  private void j()
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    boolean bool = a(e(((MetaMaterial)localObject).id), this.q);
    int i3 = 0;
    int i1;
    if (bool)
    {
      localObject = TextMetaMaterialKt.f(this.r);
      int i2 = i3;
      if (this.n != null)
      {
        i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.n.size()) {
            break;
          }
          if (((String)localObject).equals(TextMetaMaterialKt.f((MetaMaterial)this.n.get(i1))))
          {
            i2 = i1;
            break;
          }
          i1 += 1;
        }
      }
      this.i.postValue(Integer.valueOf(i2));
      return;
    }
    if (this.c != null)
    {
      i1 = 0;
      while (i1 < this.c.size())
      {
        if ((this.c.get(i1) != null) && (this.r.id.equals(((MetaMaterial)this.c.get(i1)).id))) {
          break label200;
        }
        i1 += 1;
      }
      i1 = 0;
      label200:
      this.j.postValue(Integer.valueOf(i1));
      return;
    }
    if (this.n != null)
    {
      i1 = 0;
      while (i1 < this.n.size())
      {
        if ((this.n.get(i1) != null) && (this.r.id.equals(((MetaMaterial)this.n.get(i1)).id))) {
          break label291;
        }
        i1 += 1;
      }
      i1 = 0;
      label291:
      this.i.postValue(Integer.valueOf(i1));
    }
  }
  
  private void k()
  {
    if ("CATEGORY_TEXT_STYLE".equals(this.q))
    {
      MetaMaterial localMetaMaterial = this.r;
      if (localMetaMaterial != null)
      {
        i1 = b.indexOf(Integer.valueOf(TextMetaMaterialKt.l(localMetaMaterial)));
        break label42;
      }
    }
    int i1 = -1;
    label42:
    this.k.postValue(Integer.valueOf(i1));
  }
  
  public String a()
  {
    return this.d;
  }
  
  void a(int paramInt)
  {
    String str;
    if (paramInt == 2131436786) {
      str = "CATEGORY_KEYBOARD";
    } else if (paramInt == 2131447086) {
      str = "CATEGORY_TEXT_STYLE";
    } else if (paramInt == 2131447079) {
      str = "CATEGORY_TEXT_PATTERN";
    } else if (paramInt == 2131447071) {
      str = "CATEGORY_TEXT_DECOR";
    } else {
      str = null;
    }
    b(str);
  }
  
  void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial.id == null) {
      return;
    }
    if (this.r == null) {
      return;
    }
    if ((!"TEXT_PATTERN_NON_ID".equals(paramMetaMaterial.id)) && (!"TEXT_DECOR_NON_ID".equals(paramMetaMaterial.id)))
    {
      b(paramMetaMaterial);
      return;
    }
    c(paramMetaMaterial.id);
  }
  
  void a(String paramString)
  {
    if (this.r == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = a;
    }
    if (str.equals(TextMetaMaterialKt.k(this.r))) {
      return;
    }
    TextMetaMaterialKt.g(this.r, str);
    this.h.postValue(this.r);
  }
  
  public void a(List<MetaCategory> paramList)
  {
    if (paramList.size() >= 3)
    {
      if (((MetaCategory)paramList.get(0)).materials != null)
      {
        this.n.clear();
        this.n.addAll(TextMetaMaterialKt.a("CATEGORY_TEXT_STYLE", ((MetaCategory)paramList.get(0)).materials));
        this.n.add(0, TextMetaMaterialKt.a());
        this.f.postValue(this.n);
      }
      if (((MetaCategory)paramList.get(1)).materials != null)
      {
        this.o.clear();
        this.o.addAll(TextMetaMaterialKt.a("CATEGORY_TEXT_PATTERN", ((MetaCategory)paramList.get(1)).materials));
        this.o.add(0, TextMetaMaterialKt.a("TEXT_PATTERN_NON_ID"));
      }
      if (((MetaCategory)paramList.get(2)).materials != null)
      {
        this.p.clear();
        this.p.addAll(TextMetaMaterialKt.a("CATEGORY_TEXT_DECOR", ((MetaCategory)paramList.get(2)).materials));
        this.p.add(0, TextMetaMaterialKt.a("TEXT_DECOR_NON_ID"));
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      WinkStickerModel localWinkStickerModel = this.s;
      if (localWinkStickerModel != null)
      {
        TextMetaMaterialKt.c((MetaMaterial)localObject, localWinkStickerModel.centerX);
        TextMetaMaterialKt.d(this.r, this.s.centerY);
        TextMetaMaterialKt.b(this.r, this.s.rotate);
      }
      this.m.postValue(this.r);
    }
    else
    {
      localObject = this.s;
      if (localObject != null) {
        this.l.postValue(localObject);
      }
    }
    this.r = null;
    this.s = null;
    this.q = null;
  }
  
  public boolean a(WinkStickerModel paramWinkStickerModel)
  {
    if (!b(paramWinkStickerModel)) {
      return false;
    }
    this.r = paramWinkStickerModel.getMaterial();
    this.s = paramWinkStickerModel;
    this.h.postValue(this.r);
    b(MetaMaterialKt.d(this.r));
    return true;
  }
  
  void b()
  {
    if (this.s == null)
    {
      this.r = TextMetaMaterialKt.a();
      this.h.postValue(this.r);
      b("CATEGORY_KEYBOARD");
    }
  }
  
  void b(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.q)))
    {
      String str = paramString;
      if ("CATEGORY_TEXT_STYLE".equals(paramString)) {
        str = "CATEGORY_KEYBOARD";
      }
      this.q = str;
      paramString = this.q;
      int i1 = -1;
      int i2 = paramString.hashCode();
      if (i2 != -921884268)
      {
        if ((i2 == 793913343) && (paramString.equals("CATEGORY_TEXT_PATTERN"))) {
          i1 = 0;
        }
      }
      else if (paramString.equals("CATEGORY_TEXT_DECOR")) {
        i1 = 1;
      }
      if (i1 != 0)
      {
        if (i1 == 1) {
          this.c = this.p;
        }
      }
      else {
        this.c = this.o;
      }
      this.e.postValue(this.q);
      this.g.postValue(this.c);
      j();
      k();
      return;
    }
    j();
    k();
  }
  
  public boolean b(WinkStickerModel paramWinkStickerModel)
  {
    if (paramWinkStickerModel == null) {
      return false;
    }
    paramWinkStickerModel = paramWinkStickerModel.getMaterial();
    if (paramWinkStickerModel == null) {
      return false;
    }
    return TextMetaMaterialKt.a(paramWinkStickerModel);
  }
  
  public String c()
  {
    return this.q;
  }
  
  LiveData<String> d()
  {
    return this.e;
  }
  
  LiveData<List<MetaMaterial>> e()
  {
    return this.g;
  }
  
  LiveData<MetaMaterial> f()
  {
    return this.h;
  }
  
  LiveData<Integer> g()
  {
    return this.j;
  }
  
  LiveData<WinkStickerModel> h()
  {
    return this.l;
  }
  
  LiveData<MetaMaterial> i()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.WinkEditorTextViewModel
 * JD-Core Version:    0.7.0.1
 */