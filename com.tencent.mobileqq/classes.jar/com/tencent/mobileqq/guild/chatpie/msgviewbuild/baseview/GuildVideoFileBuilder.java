package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.AIOFilePicMask;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.ViewHolder;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class GuildVideoFileBuilder
  extends BaseGuildMsgViewBuild
  implements View.OnClickListener, Callback
{
  private Drawable a;
  private GuildFileBubbleModel l = new GuildFileBubbleModel(paramQQAppInterface, this.b, this.c);
  
  public GuildVideoFileBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    if ((FileUtil.b(paramFileManagerEntity.getFilePath())) && (FileManagerUtil.f(paramFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new GuildVideoFileBuilder.1(this, paramFileManagerEntity));
      return;
    }
    this.l.l();
  }
  
  private void a(GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (paramVideoFileHolder.j == null) {
      return;
    }
    paramVideoFileHolder.b.setVisibility(4);
    paramVideoFileHolder.c.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.b);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(c());
    } else {
      localRelativeLayout.setBackgroundDrawable(c());
    }
    Object localObject = new TextView(this.b);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
    ((TextView)localObject).setText(HardCodeUtil.a(2131912649));
    ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(7.0F, this.b.getResources()));
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130851866, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(paramVideoFileHolder.e, paramVideoFileHolder.f);
    ((RelativeLayout)paramVideoFileHolder.j).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = FileUtils.getFileSize(paramFileManagerEntity.fileSize);
    a(paramFileManagerEntity.fileName, (String)localObject, paramVideoFileHolder, localRelativeLayout, true);
    paramVideoFileHolder.g = localRelativeLayout;
  }
  
  private void a(GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, GuildMsgItemLayout paramGuildMsgItemLayout, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    c(paramVideoFileHolder, paramFileManagerEntity);
    Object localObject = FileUtils.getFileSize(paramFileManagerEntity.fileSize);
    a(paramFileManagerEntity.fileName, (String)localObject, paramVideoFileHolder, (RelativeLayout)paramVideoFileHolder.j, false);
    paramVideoFileHolder.c.setVisibility(0);
    if (paramVideoFileHolder.g != null)
    {
      paramVideoFileHolder.g.removeAllViews();
      ((RelativeLayout)paramVideoFileHolder.j).removeView(paramVideoFileHolder.g);
    }
    localObject = b(paramVideoFileHolder, paramFileManagerEntity);
    paramVideoFileHolder.b.setImageResource(2130845704);
    paramVideoFileHolder.b.setImageDrawable((Drawable)localObject);
    b(paramVideoFileHolder, paramGuildMsgItemLayout, paramFileManagerEntity, paramChatMessage);
  }
  
  private void a(GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = FileManagerUtil.w(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramVideoFileHolder.e = i;
      paramVideoFileHolder.f = j;
      paramFileManagerEntity.imgWidth = i;
      paramFileManagerEntity.imgHeight = j;
      this.l.a(i, j);
    }
    c(paramVideoFileHolder, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramVideoFileHolder.d != null)
    {
      paramVideoFileHolder.d.removeAllViews();
      ((RelativeLayout)paramVideoFileHolder.j).removeView(paramVideoFileHolder.d);
    }
    Object localObject1 = new RelativeLayout(this.b);
    ((RelativeLayout)localObject1).setId(2131430544);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839253);
    paramVideoFileHolder.d = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, this.b.getResources()));
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131440242);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131440242);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131440242);
      if (paramVideoFileHolder.b.v)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(6.0F, this.b.getResources());
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(6.0F, this.b.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    }
    paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    int i = QFileUtils.a(paramVideoFileHolder.e, paramVideoFileHolder.f);
    paramViewGroup = new TextView(this.b);
    paramViewGroup.setId(2131430544);
    paramViewGroup.setTextSize(2, 12.0F);
    paramViewGroup.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(7.0F, this.b.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(7.0F, this.b.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(7.0F, this.b.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.b, null);
    ((TextView)localObject2).setId(2131430547);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.b(7.0F, this.b.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(7.0F, this.b.getResources());
    localLayoutParams.bottomMargin = AIOUtils.b(7.0F, this.b.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131430544);
    }
    else
    {
      localLayoutParams.addRule(12);
    }
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject1 = QFileUtils.a(this.b, i, paramVideoFileHolder.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
    if (i != 1)
    {
      if (i == 2)
      {
        ((TextView)localObject2).setLines(1);
        ((TextView)localObject2).setMaxLines(1);
        paramViewGroup.setGravity(5);
      }
    }
    else
    {
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      paramViewGroup.setGravity(3);
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    paramViewGroup.setText(paramString2);
    if (paramVideoFileHolder.c != null)
    {
      paramViewGroup = paramVideoFileHolder.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramString2);
      paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
    }
    if (paramVideoFileHolder.b != null)
    {
      paramVideoFileHolder = paramVideoFileHolder.b;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramString1);
      paramViewGroup.append(" ");
      paramViewGroup.append(paramString2);
      paramVideoFileHolder.setContentDescription(paramViewGroup.toString());
    }
  }
  
  private Drawable b(GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    String str = paramFileManagerEntity.strLargeThumPath;
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      int i = this.l.d();
      int j = this.l.e();
      if ((i == 0) || (j == 0)) {
        a(paramVideoFileHolder, str, paramFileManagerEntity);
      }
      paramFileManagerEntity = URLDrawable.URLDrawableOptions.obtain();
      paramFileManagerEntity.mRequestWidth = paramVideoFileHolder.e;
      paramFileManagerEntity.mRequestHeight = paramVideoFileHolder.f;
      paramFileManagerEntity.mLoadingDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramVideoFileHolder.e, paramVideoFileHolder.f);
      paramFileManagerEntity.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      paramFileManagerEntity.mGifRoundCorner = 6.0F;
      paramFileManagerEntity.mPlayGifImage = false;
      paramFileManagerEntity = URLDrawable.getFileDrawable(str, paramFileManagerEntity);
      paramFileManagerEntity.setAutoDownload(true);
      paramVideoFileHolder.b.setVisibility(0);
      return paramFileManagerEntity;
    }
    a(paramFileManagerEntity);
    return c();
  }
  
  private void b(GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, GuildMsgItemLayout paramGuildMsgItemLayout, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    int j = paramFileManagerEntity.status;
    int i;
    if (this.l.i() == 6) {
      i = 1;
    } else {
      i = 0;
    }
    this.l.x().a(paramVideoFileHolder, paramGuildMsgItemLayout, paramChatMessage);
    if ((j != 16) && (i == 0))
    {
      if (j == 2)
      {
        i = (int)(paramFileManagerEntity.fProgress * 100.0F);
        if (i < 100)
        {
          paramVideoFileHolder.c.setDrawStatus(1);
          paramGuildMsgItemLayout = paramVideoFileHolder.c;
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append(paramVideoFileHolder.q.frienduin);
          paramFileManagerEntity.append(paramVideoFileHolder.q.uniseq);
          paramGuildMsgItemLayout.setAnimProgress(i, paramFileManagerEntity.toString());
          return;
        }
        paramVideoFileHolder.c.setDrawStatus(2);
        paramGuildMsgItemLayout = paramVideoFileHolder.c;
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(paramVideoFileHolder.q.frienduin);
        paramFileManagerEntity.append(paramVideoFileHolder.q.uniseq);
        paramGuildMsgItemLayout.setAnimProgress(i, paramFileManagerEntity.toString());
        return;
      }
      if ((j != 0) && (j != 3))
      {
        paramGuildMsgItemLayout = paramVideoFileHolder.c;
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append(paramVideoFileHolder.q.frienduin);
        paramFileManagerEntity.append(paramVideoFileHolder.q.uniseq);
        if (paramGuildMsgItemLayout.c(paramFileManagerEntity.toString()))
        {
          paramVideoFileHolder.c.setDrawFinishDefault(true);
          paramGuildMsgItemLayout = paramVideoFileHolder.c;
          paramFileManagerEntity = new StringBuilder();
          paramFileManagerEntity.append(paramVideoFileHolder.q.frienduin);
          paramFileManagerEntity.append(paramVideoFileHolder.q.uniseq);
          paramGuildMsgItemLayout.setAnimProgress(100, paramFileManagerEntity.toString());
          return;
        }
        paramVideoFileHolder.c.setDrawStatus(2);
        return;
      }
      paramGuildMsgItemLayout = HardCodeUtil.a(2131912632);
      paramVideoFileHolder.c.setImageResource(2130851865);
      paramVideoFileHolder.c.setContentDescription(paramGuildMsgItemLayout);
      paramVideoFileHolder.c.setDrawStatus(3);
      paramVideoFileHolder.c.setDrawFinishDefault(true);
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
    {
      c(paramVideoFileHolder, paramFileManagerEntity);
      a(paramVideoFileHolder, paramFileManagerEntity);
    }
  }
  
  private void c(GuildVideoFileBuilder.VideoFileHolder paramVideoFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    int i = this.l.d();
    int j = this.l.e();
    if (i <= 0) {
      i = 640;
    }
    if (j <= 0) {
      j = 480;
    }
    paramFileManagerEntity = ShortVideoUtils.adjustSize(i, j);
    i = paramFileManagerEntity[0];
    j = paramFileManagerEntity[1];
    paramFileManagerEntity = paramVideoFileHolder.b.getLayoutParams();
    if (paramFileManagerEntity == null)
    {
      paramFileManagerEntity = new RelativeLayout.LayoutParams(i, j);
      paramVideoFileHolder.b.setLayoutParams(paramFileManagerEntity);
    }
    else if ((paramFileManagerEntity.width != i) || (paramFileManagerEntity.height != j))
    {
      paramFileManagerEntity.width = i;
      paramFileManagerEntity.height = j;
      paramVideoFileHolder.b.setLayoutParams(paramFileManagerEntity);
    }
    paramFileManagerEntity = paramVideoFileHolder.c.getLayoutParams();
    if (paramFileManagerEntity == null)
    {
      paramFileManagerEntity = new LinearLayout.LayoutParams(i, j);
      paramVideoFileHolder.c.setLayoutParams(paramFileManagerEntity);
    }
    else if ((paramFileManagerEntity.width != i) || (paramFileManagerEntity.height != j))
    {
      paramFileManagerEntity.width = i;
      paramFileManagerEntity.height = j;
      paramVideoFileHolder.c.setLayoutParams(paramFileManagerEntity);
    }
    paramVideoFileHolder.e = i;
    paramVideoFileHolder.f = j;
  }
  
  private void g(View paramView)
  {
    ChatMessage localChatMessage = ((BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView)).q;
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.g, (MessageForFile)localChatMessage);
    if (localFileManagerEntity == null)
    {
      QLog.e("GuildVideoFileBuilder", 1, "get Entity by Msg faild!");
      return;
    }
    if (this.l.i() == 6)
    {
      paramView = this.b.getString(2131890381);
      QQToast.makeText(this.b, 1, paramView, 1).show();
      return;
    }
    if (localFileManagerEntity.status == 16)
    {
      paramView = this.b.getString(2131890380);
      QQToast.makeText(this.b, 1, paramView, 1).show();
      return;
    }
    if (!QFileUtils.a(localFileManagerEntity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildVideoFileBuilder", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
      }
      return;
    }
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!FileUtil.b(localFileManagerEntity.getFilePath())))
    {
      FMToastUtil.a(HardCodeUtil.a(2131902587));
      return;
    }
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.g, this.b, this.c, localChatMessage, paramView, 1, 10004, localFileManagerEntity, false, false);
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.l.b(paramChatMessage);
    GuildVideoFileBuilder.VideoFileHolder localVideoFileHolder = (GuildVideoFileBuilder.VideoFileHolder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.b);
      paramView = new BubbleVideoView(this.b);
      paramView.setId(2131440242);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.c(false);
      paramView.setSharpCornerCor(BubbleImageView.d);
      paramViewHolder.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(this.b);
      localMessageProgressView.setId(2131430626);
      localMessageProgressView.setRadius(15.0F, true);
      localMessageProgressView.setShowCorner(false);
      localMessageProgressView.setSharpCornerCor(BubbleImageView.d);
      paramViewHolder.addView(localMessageProgressView);
      paramView.setOnClickListener(this);
      super.a(paramView, paramOnLongClickAndTouchListener);
      localVideoFileHolder.b = paramView;
      localVideoFileHolder.c = localMessageProgressView;
    }
    boolean bool = paramChatMessage.isSend();
    localVideoFileHolder.c.setCornerDirection(bool);
    if (localVideoFileHolder.b.v != bool)
    {
      localVideoFileHolder.b.setSend(bool);
      localVideoFileHolder.b.invalidate();
    }
    localVideoFileHolder.c.setOnClickListener(this);
    super.a(localVideoFileHolder.c, paramOnLongClickAndTouchListener);
    paramView = localVideoFileHolder.c;
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramChatMessage.frienduin);
    paramOnLongClickAndTouchListener.append(paramChatMessage.uniseq);
    paramView.a(paramOnLongClickAndTouchListener.toString());
    localVideoFileHolder.j = paramViewHolder;
    a(localVideoFileHolder, paramGuildMsgItemLayout, FileManagerUtil.a(this.g, (MessageForFile)paramChatMessage), paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildVideoFileBuilder.VideoFileHolder(this);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected boolean b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = this.b.getString(2131889299);
    String str = this.b.getString(2131889298);
    if (!localChatMessage.isSendFromLocal())
    {
      paramView = this.b.getString(2131886576);
      str = this.b.getString(2131886576);
    }
    DialogUtil.a(this.b, 230, paramView, str, -..Lambda.GuildVideoFileBuilder.OvJwqNd1aJOjOenAhCsg1O8qZGA.INSTANCE, -..Lambda.GuildVideoFileBuilder.Eb3tDTVpNkfJWg23YiMjn5VjZYE.INSTANCE).show();
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public Drawable c()
  {
    if (this.a == null)
    {
      float f = this.e;
      this.a = new AIOFilePicMask(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.a;
  }
  
  public BaseBubbleBuilder.TouchDelegate c(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.b(paramView);
      if ((paramView != null) && (GuildVideoFileBuilder.VideoFileHolder.class.isInstance(paramView)))
      {
        paramView = (GuildVideoFileBuilder.VideoFileHolder)paramView;
        if (paramView != null) {
          return paramView.b;
        }
      }
    }
    return null;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131440242) && (i != 2131430626))
    {
      super.onClick(paramView);
      return;
    }
    g(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildVideoFileBuilder
 * JD-Core Version:    0.7.0.1
 */