package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class QlinkSendBarManager
  extends QFileCustomBottomBarManager
{
  private int g;
  private boolean h;
  private String i;
  private TextView j;
  private TextView k;
  private View.OnClickListener l = new QlinkSendBarManager.1(this);
  
  public QlinkSendBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.j = ((TextView)this.c.a(2131445568));
    this.k = ((TextView)this.c.a(2131439377));
    this.j.setOnClickListener(this.l);
  }
  
  private void d()
  {
    if ((this.d != null) && (this.d.containsKey("qfile_search_param_exparams_qlink_state")))
    {
      Object localObject1 = this.i;
      Object localObject2 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject2).next()).d());
      }
      int m = this.d.getInt("qfile_search_param_exparams_qlink_state");
      localObject2 = new Intent();
      int n = -1;
      if (222 == m)
      {
        ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
        m = n;
      }
      else if ((333 != m) && (666 != m) && (3333 != m) && (6666 != m))
      {
        boolean bool = true;
        if ((444 != m) && (555 != m))
        {
          if ((777 != m) && (888 != m))
          {
            this.b.getQQProxyForQlink().a((String)localObject1, localArrayList);
            ((Intent)localObject2).putExtra("_UIN_", (String)localObject1);
            ((Intent)localObject2).putExtra("_SEND_QLINK_FILE_", true);
            m = n;
          }
          else
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putStringArrayList("string_filepaths", localArrayList);
            this.b.getQQProxyForQlink();
            QQProxyForQlink.a(this.a, 16, (Bundle)localObject1);
            m = n;
          }
        }
        else
        {
          if (444 != m) {
            bool = false;
          }
          ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
          ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
        }
      }
      else
      {
        ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
      }
      a(m, (Intent)localObject2);
      return;
    }
    a(null);
  }
  
  public void a()
  {
    this.k.setText(2131896328);
    this.j.setText(HardCodeUtil.a(2131899883));
    TextView localTextView = this.j;
    boolean bool;
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localTextView.setEnabled(bool);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.e)
    {
      this.i = this.d.getString("qfile_search_param_ex_params_target_uin");
      this.g = this.d.getInt("qfile_search_param_exparams_qlink_state");
      this.h = this.d.getBoolean("qfile_search_param_exparams_qlink_ap_created");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.QlinkSendBarManager
 * JD-Core Version:    0.7.0.1
 */