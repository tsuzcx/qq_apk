package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.ViewHolder;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class GuildSimpleFileBuilder
  extends BaseGuildMsgViewBuild
  implements View.OnClickListener, Callback
{
  GuildFileBubbleModel a = new GuildFileBubbleModel(paramQQAppInterface, this.b, this.c);
  private GuildSimpleFileBubbleOpStatusHandler l;
  
  public GuildSimpleFileBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.l = new GuildSimpleFileBubbleOpStatusHandler(paramQQAppInterface, paramContext);
  }
  
  private String a(long paramLong)
  {
    paramLong *= 1000L;
    long l1 = System.currentTimeMillis();
    if (paramLong <= l1) {
      return this.b.getString(2131895110);
    }
    paramLong = (paramLong - l1) / 86400000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong + 1L);
    localStringBuilder.append(this.b.getString(2131895083));
    return localStringBuilder.toString();
  }
  
  private void a(GuildSimpleFileBuilder.SimpleFileHolder paramSimpleFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    this.l.a(paramSimpleFileHolder, paramFileManagerEntity);
  }
  
  private void a(GuildSimpleFileBuilder.SimpleFileHolder paramSimpleFileHolder, FileManagerEntity paramFileManagerEntity, GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    paramGuildMsgItemLayout = this.b.getResources();
    int m = paramFileManagerEntity.status;
    AIOUtils.b(14.0F, this.b.getResources());
    int i = AIOUtils.b(10.0F, this.b.getResources());
    int j = AIOUtils.b(16.0F, this.b.getResources());
    int k = AIOUtils.b(15.0F, this.b.getResources());
    if (m == 2)
    {
      m = (int)(paramFileManagerEntity.fProgress * 100.0F);
      paramSimpleFileHolder.f.setProgress(m);
      paramSimpleFileHolder.f.setVisibility(0);
      if ((paramSimpleFileHolder.i >= 0) && (m - paramSimpleFileHolder.i > 1))
      {
        paramSimpleFileHolder.i = m;
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(this.b.getString(2131889388));
        paramFileManagerEntity.append(m);
        QQAppInterface.speak(paramFileManagerEntity.toString());
      }
      paramFileManagerEntity = paramSimpleFileHolder.f;
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(this.b.getString(2131889388));
      paramChatMessage.append(m);
      paramFileManagerEntity.setContentDescription(paramChatMessage.toString());
      paramFileManagerEntity = new LinearLayout.LayoutParams(-1, AIOUtils.b(96.0F, paramGuildMsgItemLayout));
      paramSimpleFileHolder.g.setLayoutParams(paramFileManagerEntity);
    }
    else
    {
      paramSimpleFileHolder.f.setVisibility(8);
      paramFileManagerEntity = new LinearLayout.LayoutParams(-1, AIOUtils.b(106.0F, paramGuildMsgItemLayout));
      paramSimpleFileHolder.g.setLayoutParams(paramFileManagerEntity);
    }
    paramSimpleFileHolder.g.setPadding(j, i, k, 0);
  }
  
  private void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, FileManagerEntity paramFileManagerEntity, GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileData:");
      ((StringBuilder)localObject).append(paramViewHolder.getClass().getName());
      QLog.d("GuildFileBuilder", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramViewHolder instanceof GuildSimpleFileBuilder.SimpleFileHolder)) {
      paramViewHolder = (GuildSimpleFileBuilder.SimpleFileHolder)paramViewHolder;
    } else {
      paramViewHolder = new GuildSimpleFileBuilder.SimpleFileHolder();
    }
    String str = paramFileManagerEntity.fileName;
    Object localObject = str;
    if (paramFileManagerEntity.nFileType == 5)
    {
      localObject = str;
      if (!str.endsWith(".apk"))
      {
        localObject = str;
        if (paramFileManagerEntity.isSend()) {
          localObject = QQFileManagerUtil.n(paramFileManagerEntity.strFilePath);
        }
      }
    }
    FileManagerUtil.a(paramViewHolder.h, (String)localObject);
    paramViewHolder.b.setText((CharSequence)localObject);
    a(paramViewHolder, paramFileManagerEntity);
    long l1 = paramFileManagerEntity.fileSize;
    paramViewHolder.c.setText(FileUtil.a(l1, this.b.getResources().getDisplayMetrics().densityDpi));
    a(paramViewHolder, paramFileManagerEntity, paramGuildMsgItemLayout, paramChatMessage);
    b(paramViewHolder, paramFileManagerEntity);
  }
  
  private boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IGProGuildInfo localIGProGuildInfo = ((IGPSService)this.g.getRuntimeService(IGPSService.class, "")).getGuildInfoForGuest(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildInfo is ");
      if (localIGProGuildInfo == null) {
        paramString = "null";
      } else {
        paramString = "not null";
      }
      localStringBuilder.append(paramString);
      QLog.d("GuildChatContext", 2, localStringBuilder.toString());
      if ((localIGProGuildInfo != null) && (!localIGProGuildInfo.isMember()))
      {
        bool = true;
        break label102;
      }
    }
    boolean bool = false;
    label102:
    paramString = new StringBuilder();
    paramString.append("isGuest = ");
    paramString.append(bool);
    QLog.d("GuildChatContext", 2, paramString.toString());
    return bool;
  }
  
  private void b(GuildSimpleFileBuilder.SimpleFileHolder paramSimpleFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    int i = paramFileManagerEntity.status;
    if (i == 16)
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(" / ");
      paramFileManagerEntity.append(this.b.getString(2131889340));
      paramFileManagerEntity = paramFileManagerEntity.toString();
    }
    else if (i == 0)
    {
      if (paramFileManagerEntity.isSend())
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(" / ");
        paramFileManagerEntity.append(this.b.getString(2131889344));
        paramFileManagerEntity = paramFileManagerEntity.toString();
      }
      else
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(" / ");
        paramFileManagerEntity.append(this.b.getString(2131889343));
        paramFileManagerEntity = paramFileManagerEntity.toString();
      }
    }
    else if (i == 3)
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append(" / ");
      paramFileManagerEntity.append(this.b.getString(2131889342));
      paramFileManagerEntity = paramFileManagerEntity.toString();
    }
    else
    {
      if (i == 1)
      {
        if (paramFileManagerEntity.nOpType == 52)
        {
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append(" / ");
          paramFileManagerEntity.append(this.b.getString(2131889345));
          paramFileManagerEntity = paramFileManagerEntity.toString();
          break label399;
        }
        if (paramFileManagerEntity.nOpType == 53)
        {
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append(" / ");
          paramFileManagerEntity.append(this.b.getString(2131889337));
          paramFileManagerEntity = paramFileManagerEntity.toString();
          break label399;
        }
      }
      else if (((i == -1) || (i == 2)) && (paramFileManagerEntity.nOpType == 53))
      {
        if (this.a.i() == 6)
        {
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append(" / ");
          paramFileManagerEntity.append(this.b.getString(2131889339));
          paramFileManagerEntity = paramFileManagerEntity.toString();
          break label399;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" / ");
        localStringBuilder.append(a(paramFileManagerEntity.lastTime));
        paramFileManagerEntity = localStringBuilder.toString();
        break label399;
      }
      paramFileManagerEntity = "";
    }
    label399:
    if (!TextUtils.isEmpty(paramFileManagerEntity))
    {
      paramSimpleFileHolder.d.setVisibility(0);
      paramSimpleFileHolder.d.setText(paramFileManagerEntity);
      return;
    }
    paramSimpleFileHolder.d.setVisibility(8);
  }
  
  private GuildChatPie c()
  {
    if (!(this.b instanceof BaseActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((BaseActivity)this.b).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("GuildFileBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return (GuildChatPie)localChatFragment.k();
  }
  
  private void g(View paramView)
  {
    Object localObject = ((BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView)).q;
    paramView = FileManagerUtil.a(this.g, (MessageForFile)localObject);
    this.a.b((ChatMessage)localObject);
    if (this.a.i() == 6)
    {
      paramView = this.b.getString(2131890381);
      QQToast.makeText(this.b, 1, paramView, 1).show();
      return;
    }
    if (paramView.status == 16)
    {
      paramView = this.b.getString(2131890380);
      QQToast.makeText(this.b, 1, paramView, 1).show();
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("file_browser_extra_params_uin", this.c.b);
    paramView = new FileModelAdapter(this.g, paramView);
    paramView.a((Bundle)localObject);
    localObject = new FileBrowserParam().a(13);
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.b, paramView, (IFileBrowserParam)localObject);
  }
  
  private void h(View paramView)
  {
    ChatMessage localChatMessage = ((BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView)).q;
    this.l.a((ImageView)paramView, localChatMessage);
    c().V.notifyDataSetChanged();
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.a.b(paramChatMessage);
    paramViewHolder = (GuildSimpleFileBuilder.SimpleFileHolder)paramViewHolder;
    if (paramView == null)
    {
      Resources localResources = this.b.getResources();
      int j = AIOUtils.b(14.0F, localResources);
      int k = AIOUtils.b(12.0F, localResources);
      int i = AIOUtils.b(6.0F, localResources);
      paramView = new RelativeLayout(this.b);
      paramView.setId(2131430578);
      paramView.setPadding(0, 0, 0, 0);
      Object localObject1 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z + 154, -2);
      localResources.getDimensionPixelSize(2131299800);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131435219);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.b);
      ((LinearLayout)localObject1).setMinimumHeight(AIOUtils.b(112.0F, localResources));
      ((LinearLayout)localObject1).setMinimumWidth(AIOUtils.b(354.0F, localResources));
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject2 = new RelativeLayout.LayoutParams(AIOUtils.b(354.0F, localResources), AIOUtils.b(112.0F, localResources));
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 2131430578);
      Object localObject3 = localResources.getDrawable(2130840649);
      ((LinearLayout)localObject1).setBackgroundDrawable((Drawable)localObject3);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramView.addOnLayoutChangeListener(new GuildSimpleFileBuilder.3(this, localResources, (Drawable)localObject3));
      ((Drawable)localObject3).setLevel(100);
      localObject2 = new RelativeLayout(this.b);
      ((RelativeLayout)localObject2).setId(2131433128);
      localObject3 = new LinearLayout.LayoutParams(-1, AIOUtils.b(96.0F, localResources));
      ((RelativeLayout)localObject2).setPadding(k, k, k, 0);
      ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.g = ((RelativeLayout)localObject2);
      k = AIOUtils.b(68.0F, localResources);
      localObject3 = new AsyncImageView(this.b);
      ((AsyncImageView)localObject3).setWidth(k);
      ((AsyncImageView)localObject3).setHeight(k);
      ((AsyncImageView)localObject3).setId(2131430545);
      ((AsyncImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject4 = new RelativeLayout.LayoutParams(k, k);
      ((RelativeLayout.LayoutParams)localObject4).addRule(11);
      ((RelativeLayout.LayoutParams)localObject4).addRule(10);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, AIOUtils.b(2.0F, localResources), 0, 0);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramViewHolder.h = ((AsyncImageView)localObject3);
      localObject3 = new EllipsizingTextView(this.b, null);
      ((TextView)localObject3).setId(2131430547);
      ((TextView)localObject3).setGravity(48);
      ((TextView)localObject3).setIncludeFontPadding(false);
      ((TextView)localObject3).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject3).setTextSize(1, 16.0F);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setTypeface(Typeface.defaultFromStyle(1));
      ((TextView)localObject3).setTextColor(Color.parseColor("#03081a"));
      localObject4 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(0, 2131430545);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(10);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramViewHolder.b = ((TextView)localObject3);
      localObject3 = new TextView(this.b);
      ((TextView)localObject3).setId(2131430544);
      ((TextView)localObject3).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject3).setAlpha(0.75F);
      }
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setTextColor(Color.parseColor("#B2B2B2"));
      ((TextView)localObject3).setTextSize(1, 12.0F);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, AIOUtils.b(8.0F, localResources));
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramViewHolder.c = ((TextView)localObject3);
      localObject3 = new TextView(this.b);
      ((TextView)localObject3).setId(2131430549);
      ((TextView)localObject3).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject3).setAlpha(0.75F);
      }
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setTextColor(Color.parseColor("#B2B2B2"));
      ((TextView)localObject3).setTextSize(1, 12.0F);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131430544);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131430544);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, i, 0, 0);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramViewHolder.d = ((TextView)localObject3);
      localObject3 = new ProgressBar(this.b, null, 16842872);
      ((ProgressBar)localObject3).setId(2131430548);
      ((ProgressBar)localObject3).setMax(100);
      ((ProgressBar)localObject3).setProgressDrawable(localResources.getDrawable(2130845716));
      localObject4 = new LinearLayout.LayoutParams(-1, AIOUtils.b(2.0F, localResources));
      ((LinearLayout.LayoutParams)localObject4).setMargins(AIOUtils.b(16.0F, this.b.getResources()), i, AIOUtils.b(41.0F, this.b.getResources()), -j);
      ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramViewHolder.f = ((ProgressBar)localObject3);
      localObject1 = new ImageView(this.b);
      ((ImageView)localObject1).setId(2131430597);
      j = AIOUtils.b(18.0F, localResources);
      localObject3 = new RelativeLayout.LayoutParams(j, j);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131430549);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131430549);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, 0, AIOUtils.b(-2.0F, localResources));
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setOnClickListener(this);
      ((ImageView)localObject1).setClickable(true);
      paramViewHolder.e = ((ImageView)localObject1);
    }
    paramView.setOnClickListener(this);
    super.a(paramView, paramOnLongClickAndTouchListener);
    a(paramViewHolder, FileManagerUtil.a(this.g, (MessageForFile)paramChatMessage), paramGuildMsgItemLayout, paramChatMessage);
    return paramView;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildSimpleFileBuilder.SimpleFileHolder();
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    if (QQFileManagerUtil.z(FileManagerUtil.a(this.g, (MessageForFile)paramChatMessage).getFilePath())) {
      paramQQCustomMenu.a(2131433636, this.b.getString(2131889668), 2130839066);
    }
    return paramQQCustomMenu;
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu2 = new QQCustomMenu();
    BaseGuildMsgViewBuild.ViewHolder localViewHolder = (BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView);
    QQCustomMenu localQQCustomMenu1 = localQQCustomMenu2;
    if (localViewHolder != null)
    {
      localQQCustomMenu1 = a(localQQCustomMenu2, localViewHolder.q);
      a(localQQCustomMenu1, paramView.getContext(), 2131439015, localViewHolder.q, null);
    }
    return localQQCustomMenu1.d();
  }
  
  public boolean b(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean b(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    String str1 = this.b.getString(2131886574);
    String str2 = this.b.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.b, 230, str1, str2, new GuildSimpleFileBuilder.1(this), new GuildSimpleFileBuilder.2(this)).show();
    }
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (a(this.c.c))
    {
      QQToast.makeText(this.b, 1, this.b.getString(2131890379), 1).show();
      return;
    }
    int i = paramView.getId();
    if (i == 2131430578)
    {
      g(paramView);
      return;
    }
    if (i == 2131430597)
    {
      h(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildSimpleFileBuilder
 * JD-Core Version:    0.7.0.1
 */