package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocConvertConfigBean
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private int f = -1;
  private String g = "https://eim.connect.qq.com/guide/install.html?install=1";
  private boolean h;
  private int i = -1;
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private int n = -1;
  private String o = "";
  private String p = "";
  private int q = -1;
  private boolean r;
  private boolean s;
  private String t = "";
  private Map<String, Long> u = new HashMap();
  
  public static TencentDocConvertConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocConvertConfigBean localTencentDocConvertConfigBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      localTencentDocConvertConfigBean = new TencentDocConvertConfigBean();
    }
    for (;;)
    {
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        if (paramArrayOfQConfItem.has("TIMDocs"))
        {
          paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("TIMDocs");
          if (paramArrayOfQConfItem.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("autoImportToSharedDocSwitch") != 1) {
              break label591;
            }
            bool = true;
            localTencentDocConvertConfigBean.a = bool;
          }
          if (paramArrayOfQConfItem.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label596;
            }
            bool = true;
            localTencentDocConvertConfigBean.b = bool;
          }
          if (paramArrayOfQConfItem.has("openFileInTimSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("openFileInTimSwitch") != 1) {
              break label601;
            }
            bool = true;
            localTencentDocConvertConfigBean.c = bool;
          }
          if (paramArrayOfQConfItem.has("aioSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("aioSwitch") != 1) {
              break label606;
            }
            bool = true;
            localTencentDocConvertConfigBean.d = bool;
          }
          if (paramArrayOfQConfItem.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("fileViewerMenuSwitch") != 1) {
              break label611;
            }
            bool = true;
            localTencentDocConvertConfigBean.e = bool;
          }
          if (paramArrayOfQConfItem.has("openFileInTimEntry")) {
            localTencentDocConvertConfigBean.f = paramArrayOfQConfItem.getInt("openFileInTimEntry");
          }
          if (paramArrayOfQConfItem.has("androidURL")) {
            localTencentDocConvertConfigBean.g = paramArrayOfQConfItem.getString("androidURL");
          }
          if (paramArrayOfQConfItem.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfQConfItem.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label616;
            }
            bool = true;
            localTencentDocConvertConfigBean.h = bool;
          }
          if (paramArrayOfQConfItem.has("timVersion")) {
            localTencentDocConvertConfigBean.i = paramArrayOfQConfItem.getInt("timVersion");
          }
          if (paramArrayOfQConfItem.has("saveTipLine0")) {
            localTencentDocConvertConfigBean.j = paramArrayOfQConfItem.getString("saveTipLine0");
          }
          if (paramArrayOfQConfItem.has("saveTipLine1")) {
            localTencentDocConvertConfigBean.k = paramArrayOfQConfItem.getString("saveTipLine1");
          }
          if (paramArrayOfQConfItem.has("saveAndCloseTipLine0")) {
            localTencentDocConvertConfigBean.l = paramArrayOfQConfItem.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfQConfItem.has("saveAndCloseTipLine1")) {
            localTencentDocConvertConfigBean.m = paramArrayOfQConfItem.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfQConfItem.has("saveTipCount")) {
            localTencentDocConvertConfigBean.n = paramArrayOfQConfItem.getInt("saveTipCount");
          }
          if (paramArrayOfQConfItem.has("contentEditedTipLine0")) {
            localTencentDocConvertConfigBean.o = paramArrayOfQConfItem.getString("contentEditedTipLine0");
          }
          if (paramArrayOfQConfItem.has("contentEditedTipLine1")) {
            localTencentDocConvertConfigBean.p = paramArrayOfQConfItem.getString("contentEditedTipLine1");
          }
          if (paramArrayOfQConfItem.has("contentEditedTipCount")) {
            localTencentDocConvertConfigBean.q = paramArrayOfQConfItem.getInt("contentEditedTipCount");
          }
          if (paramArrayOfQConfItem.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfQConfItem.getInt("docListEntryInFileSwitch") != 1) {
              break label621;
            }
            bool = true;
            localTencentDocConvertConfigBean.r = bool;
          }
          if (paramArrayOfQConfItem.has("hideDocAuthoritySettingEntry"))
          {
            if (paramArrayOfQConfItem.getInt("hideDocAuthoritySettingEntry") != 1) {
              break label626;
            }
            bool = true;
            localTencentDocConvertConfigBean.s = bool;
          }
          if (paramArrayOfQConfItem.has("docListUrl")) {
            localTencentDocConvertConfigBean.t = paramArrayOfQConfItem.getString("docListUrl");
          }
          if (paramArrayOfQConfItem.has("editSupport"))
          {
            paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfQConfItem.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localTencentDocConvertConfigBean.u.put(str, Long.valueOf(paramArrayOfQConfItem.getLong(str)));
              continue;
            }
          }
        }
        return localTencentDocConvertConfigBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
      }
      return null;
      label591:
      boolean bool = false;
      continue;
      label596:
      bool = false;
      continue;
      label601:
      bool = false;
      continue;
      label606:
      bool = false;
      continue;
      label611:
      bool = false;
      continue;
      label616:
      bool = false;
      continue;
      label621:
      bool = false;
      continue;
      label626:
      bool = false;
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.k;
  }
  
  public String k()
  {
    return this.l;
  }
  
  public String l()
  {
    return this.m;
  }
  
  public int m()
  {
    return this.n;
  }
  
  public String n()
  {
    return this.o;
  }
  
  public String o()
  {
    return this.p;
  }
  
  public int p()
  {
    return this.q;
  }
  
  public String q()
  {
    return this.t;
  }
  
  public Map<String, Long> r()
  {
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean
 * JD-Core Version:    0.7.0.1
 */