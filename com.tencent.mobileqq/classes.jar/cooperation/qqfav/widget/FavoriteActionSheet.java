package cooperation.qqfav.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class FavoriteActionSheet
  implements View.OnClickListener
{
  ShareActionSheet b = null;
  boolean c = false;
  int d = 1;
  FavoriteActionSheet.Actions e = null;
  List<Integer> f = new ArrayList();
  List<String> g = new ArrayList();
  int h = -1;
  AppRuntime i = null;
  
  public FavoriteActionSheet(Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.d = paramInt1;
    this.e = paramActions;
    this.h = paramInt2;
    this.i = paramAppRuntime;
    if (this.b == null)
    {
      paramActions = new ShareActionSheetV2.Param();
      paramActions.context = paramActivity;
      this.b = ShareActionSheetFactory.create(paramActions);
      this.b.setActionSheetTitle(paramActivity.getString(2131889851));
      this.b.setItemClickListenerV2(new FavoriteActionSheet.1(this));
    }
    b();
  }
  
  private void b()
  {
    FavoriteActionSheet.Actions localActions = this.e;
    if (localActions != null) {
      b(localActions.f());
    }
  }
  
  private void b(int paramInt)
  {
    this.d = paramInt;
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      localObject2 = ((FavoriteActionSheet.Actions)localObject1).b();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Intent();
      }
      if (localObject1 != null)
      {
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qfav");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      }
      this.b.setIntentForStartForwardRecentActivity((Intent)localObject1);
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = this.b;
    if (localObject1 != null) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    int j;
    if (localObject1 != null) {
      j = 0;
    } else {
      j = 8;
    }
    ((ShareActionSheet)localObject2).setRowVisibility(paramInt, j, 0);
    localObject1 = new ArrayList();
    RichMediaShareActionSheetUtil.a(2, (ArrayList)localObject1);
    if ((this.d & 0x200) != 0) {
      RichMediaShareActionSheetUtil.a(26, (ArrayList)localObject1);
    }
    if ((this.d & 0x4000) != 0) {
      RichMediaShareActionSheetUtil.a(64, (ArrayList)localObject1);
    }
    localObject2 = new ArrayList();
    if ((this.d & 0x80) != 0) {
      RichMediaShareActionSheetUtil.a(70, (ArrayList)localObject2);
    }
    if ((this.d & 0x100) != 0) {
      RichMediaShareActionSheetUtil.a(82, (ArrayList)localObject2);
    }
    if ((0x8 & this.d) != 0) {
      RichMediaShareActionSheetUtil.a(39, (ArrayList)localObject2);
    }
    if ((this.d & 0x400) != 0) {
      RichMediaShareActionSheetUtil.a(130, (ArrayList)localObject2);
    }
    if ((this.d & 0x8000) != 0) {
      RichMediaShareActionSheetUtil.a(131, (ArrayList)localObject2);
    }
    if ((this.d & 0x10) != 0) {
      RichMediaShareActionSheetUtil.a(94, (ArrayList)localObject2);
    }
    if ((0x40 & this.d) != 0) {
      RichMediaShareActionSheetUtil.a(129, (ArrayList)localObject2);
    }
    if ((this.d & 0x800) != 0) {
      RichMediaShareActionSheetUtil.a(52, (ArrayList)localObject2);
    }
    if ((this.d & 0x2000) != 0) {
      RichMediaShareActionSheetUtil.a(55, (ArrayList)localObject2);
    }
    if ((this.d & 0x1000) != 0) {
      RichMediaShareActionSheetUtil.a(56, (ArrayList)localObject2);
    }
    this.b.setActionSheetItems((List)localObject1, (List)localObject2);
  }
  
  public void a()
  {
    ShareActionSheet localShareActionSheet = this.b;
    if (localShareActionSheet != null)
    {
      if (localShareActionSheet.isShowing())
      {
        this.b.dismiss();
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
      this.b = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b != null)
    {
      b(paramInt);
      this.b.refresh();
    }
  }
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramInt != 2) {
      if (paramInt != 26)
      {
        if (paramInt != 39)
        {
          if (paramInt != 52)
          {
            if (paramInt != 64)
            {
              if (paramInt != 70)
              {
                if (paramInt != 82)
                {
                  if (paramInt != 94)
                  {
                    if (paramInt != 55)
                    {
                      if (paramInt != 56)
                      {
                        if (paramInt != 72)
                        {
                          if (paramInt != 73)
                          {
                            switch (paramInt)
                            {
                            default: 
                              return;
                            case 131: 
                              this.e.p();
                              return;
                            case 130: 
                              this.e.j();
                              return;
                            }
                            this.e.c();
                          }
                        }
                        else
                        {
                          Bundle localBundle = new Bundle();
                          localBundle.putInt("key_req", 1);
                          localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
                          localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
                          this.e.a(localBundle);
                        }
                      }
                      else {
                        this.e.m();
                      }
                    }
                    else {
                      this.e.l();
                    }
                  }
                  else {
                    this.e.a();
                  }
                }
                else {
                  this.e.e();
                }
              }
              else {
                this.e.d();
              }
            }
            else {
              this.e.o();
            }
          }
          else {
            this.e.k();
          }
        }
        else {
          this.e.h();
        }
      }
      else
      {
        this.e.i();
        return;
      }
    }
    this.e.g();
  }
  
  public void onClick(View paramView)
  {
    ShareActionSheet localShareActionSheet = this.b;
    if ((localShareActionSheet != null) && (!localShareActionSheet.isShowing()))
    {
      this.c = false;
      b();
      this.b.refresh();
      this.b.show();
      this.e.n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.FavoriteActionSheet
 * JD-Core Version:    0.7.0.1
 */