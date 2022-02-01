package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.usecases.FetchCreatorNameUseCase;
import com.tencent.mobileqq.guild.usecases.FetchCreatorNameUseCase.ResultCallback;
import com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase;
import com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase.ResultCallback;
import com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase.ShareUrlInfo;
import com.tencent.mobileqq.guild.util.GuildPermissionUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil.ProgressDialog;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class GuildShareActionSheet
{
  private final WeakReference<Activity> b;
  private final IGProGuildInfo c;
  private final GuildShareActionSheet.ShareItemClickListener d = new GuildShareActionSheet.ShareItemClickListener(this, null);
  private final FetchShareInfoUseCase.ResultCallback e = b();
  private final FetchCreatorNameUseCase.ResultCallback f = c();
  private final QQGuildUIUtil.ProgressDialog g;
  private final IGProChannelInfo h;
  private ShareActionSheetBuilder.ActionSheetItem i;
  private FetchShareInfoUseCase.ShareUrlInfo j = new FetchShareInfoUseCase.ShareUrlInfo("", "");
  private String k;
  private boolean l = false;
  private boolean m = false;
  private ShareActionSheet n = null;
  private int o = -1;
  private GuildShareActionSheet.ActionSheetListener p;
  
  public GuildShareActionSheet(@NonNull Activity paramActivity, @NonNull IGProGuildInfo paramIGProGuildInfo, @Nullable IGProChannelInfo paramIGProChannelInfo)
  {
    this.b = new WeakReference(paramActivity);
    this.g = QQGuildUIUtil.a(paramActivity);
    this.c = paramIGProGuildInfo;
    this.h = paramIGProChannelInfo;
    if (QQGuildUtil.d(this.c.getCreatorId()))
    {
      this.k = ((IGPSService)QQGuildUtil.a(IGPSService.class, "")).getGuildUserNick(this.c.getCreatorId());
      return;
    }
    throw new IllegalArgumentException("CreateId 不合法");
  }
  
  private static void a(Activity paramActivity)
  {
    if (paramActivity.getIntent() != null) {
      paramActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
    }
  }
  
  private boolean a(Context paramContext)
  {
    if (KaShareInterceptor.a(paramContext, this.c)) {
      return false;
    }
    if (!GuildPermissionUtils.a())
    {
      QQGuildUtil.a(QQGuildUtil.h(), -202, "暂时不可分享该频道");
      return false;
    }
    return true;
  }
  
  private FetchShareInfoUseCase.ResultCallback b()
  {
    return new GuildShareActionSheet.1(this);
  }
  
  private void b(int paramInt)
  {
    Activity localActivity = (Activity)this.b.get();
    if (localActivity != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = new ShareActionExecutor(localActivity, new ShareInfoProvider((IGProGuildInfo)localObject, this.h, this.j, this.k));
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            if (paramInt != 3)
            {
              if (paramInt != 9)
              {
                if (paramInt != 10)
                {
                  if (paramInt != 72)
                  {
                    if (paramInt != 73)
                    {
                      QLog.e("GuildShareAction", 1, "handleShare activity null");
                      QQToast.makeText(localActivity, "分享类型异常，请重试~", 0).show();
                    }
                  }
                  else
                  {
                    if ((!a) && (this.i == null)) {
                      throw new AssertionError();
                    }
                    ((ShareActionExecutor)localObject).a(this.i.uin, this.i.uinType);
                  }
                }
                else {
                  ((ShareActionExecutor)localObject).d();
                }
              }
              else {
                ((ShareActionExecutor)localObject).c();
              }
            }
            else
            {
              ((ShareActionExecutor)localObject).b();
              return;
            }
          }
          ((ShareActionExecutor)localObject).a();
          return;
        }
        ((ShareActionExecutor)localObject).e();
        return;
      }
    }
    QLog.e("GuildShareAction", 1, "handleShare activity null");
    QQToast.makeText(localActivity, "分享失败，请重试~", 0).show();
  }
  
  private static void b(@NonNull GuildError paramGuildError, Context paramContext)
  {
    paramGuildError = (IGProSecurityResult)paramGuildError.c;
    if (paramGuildError.a() == 102L) {
      try
      {
        paramGuildError = new JSONObject(paramGuildError.c()).optString("verify_url");
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramGuildError);
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramGuildError)
      {
        QLog.e("GuildShareAction", 1, paramGuildError, new Object[0]);
        return;
      }
    }
    QQToast.makeText(paramContext, 1, paramGuildError.b(), 1).show();
  }
  
  private void b(GuildShareActionSheet.ActionSheetListener paramActionSheetListener)
  {
    this.p = paramActionSheetListener;
    this.n.setOnDismissListener(new GuildShareActionSheet.3(this));
    this.n.setCancelListener(new GuildShareActionSheet.4(this));
  }
  
  private FetchCreatorNameUseCase.ResultCallback c()
  {
    return new GuildShareActionSheet.2(this);
  }
  
  private static boolean c(int paramInt)
  {
    return Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(9), Integer.valueOf(10) }).contains(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt)
  {
    Context localContext = (Context)this.b.get();
    this.o = paramInt;
    if (localContext == null)
    {
      QLog.e("GuildShareAction", 1, "share(), context is null");
      QQToast.makeText(QQGuildUtil.h(), "分享失败，请重试~", 0).show();
      return;
    }
    if (!a(localContext)) {
      return;
    }
    if ((TextUtils.isEmpty(this.j.a)) && (!this.l))
    {
      this.g.a();
      FetchShareInfoUseCase.a(this.c, this.h, this.e);
      return;
    }
    if ((TextUtils.isEmpty(this.k)) && (c(paramInt)) && (!this.m))
    {
      this.g.a();
      FetchCreatorNameUseCase.a(this.c.getCreatorId(), this.f);
      return;
    }
    b(paramInt);
  }
  
  public boolean a()
  {
    Object localObject = (Activity)this.b.get();
    if (localObject == null)
    {
      QLog.e("GuildShareAction", 1, "showActionSheet(), context null");
      return false;
    }
    if (!a((Context)localObject)) {
      return false;
    }
    a((Activity)localObject);
    this.n = new ShareActionSheetBuilder((Context)localObject).a();
    this.n.setItemClickListenerV2(this.d);
    this.n.show();
    localObject = this.p;
    if (localObject != null) {
      ((GuildShareActionSheet.ActionSheetListener)localObject).a();
    }
    return true;
  }
  
  public boolean a(GuildShareActionSheet.ActionSheetListener paramActionSheetListener)
  {
    if (a())
    {
      b(paramActionSheetListener);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.GuildShareActionSheet
 * JD-Core Version:    0.7.0.1
 */