package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.AIOFilePicMask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.AIOImgInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.ViewHolder;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class GuildImageFileBuilder
  extends BaseGuildMsgViewBuild
  implements View.OnClickListener, Callback
{
  private float a = 0.5625F;
  private int l = (int)(BaseChatItemLayout.f * this.a);
  private int m = BaseChatItemLayout.f;
  private Drawable n;
  private Drawable o;
  private float p = 0.0F;
  private GuildFileBubbleModel q;
  
  public GuildImageFileBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.p = paramContext.getResources().getDisplayMetrics().density;
    this.q = new GuildFileBubbleModel(paramQQAppInterface, this.b, this.c);
  }
  
  private int a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return 0;
    }
    if (QFileUtils.a(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight, paramFileManagerEntity.fileSize)) {
      return 1;
    }
    if (paramFileManagerEntity.thumbInvalidCode == 1) {
      return 1;
    }
    if (paramFileManagerEntity.thumbInvalidCode == 2) {
      return 2;
    }
    return 0;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    if (this.o == null)
    {
      Bitmap localBitmap = null;
      if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      } else if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      }
      this.o = new BitmapDrawableWithMargin(this.b.getResources(), localBitmap, paramInt1, paramInt2, -921103);
    }
    return this.o;
  }
  
  private Drawable a(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = this.q.h();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      i = paramFileManagerEntity.imgWidth;
      int j = paramFileManagerEntity.imgHeight;
      if ((i == 0) || (j == 0)) {
        a(paramImageFileHolder, (String)localObject, paramFileManagerEntity);
      }
      paramFileManagerEntity = a(paramImageFileHolder.g, paramImageFileHolder.h);
      paramImageFileHolder = a(paramImageFileHolder.g, paramImageFileHolder.h);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      if (localObject != null) {
        return URLDrawableHelper.getDrawable((URL)localObject, 0, 0, paramFileManagerEntity, paramImageFileHolder, true, 0.0F);
      }
      return paramFileManagerEntity;
    }
    int i = a(paramFileManagerEntity);
    if (i == 1)
    {
      a(paramImageFileHolder, i);
      return c();
    }
    if (i == 2)
    {
      b(paramFileManagerEntity);
      return a(paramImageFileHolder.g, paramImageFileHolder.h);
    }
    b(paramFileManagerEntity);
    paramImageFileHolder.i.setVisibility(0);
    return c();
  }
  
  private void a(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder)
  {
    FrameLayout localFrameLayout = paramImageFileHolder.e;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(c());
    } else {
      localFrameLayout.setBackgroundDrawable(c());
    }
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131435900);
    localTextView.setText(2131890795);
    localTextView.setCompoundDrawablePadding(AIOUtils.b(7.0F, this.b.getResources()));
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130851866, 0, 0);
    localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramImageFileHolder.g, paramImageFileHolder.h));
  }
  
  private void a(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, int paramInt)
  {
    if (paramInt == 1)
    {
      FrameLayout localFrameLayout = paramImageFileHolder.e;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 16) {
        localFrameLayout.setBackground(c());
      } else {
        localFrameLayout.setBackgroundDrawable(c());
      }
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131435900);
      localTextView.setText(2131889389);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(AIOUtils.b(4.0F, this.b.getResources()));
      Drawable localDrawable = this.b.getResources().getDrawable(2130846249);
      localDrawable.setBounds(0, 0, AIOUtils.b(28.0F, this.b.getResources()), AIOUtils.b(28.0F, this.b.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramImageFileHolder.g, paramImageFileHolder.h));
    }
  }
  
  private void a(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, int paramInt, boolean paramBoolean)
  {
    PicProgressView localPicProgressView;
    Object localObject;
    if (paramBoolean)
    {
      if (paramImageFileHolder.c == null)
      {
        localPicProgressView = new PicProgressView(this.b);
        localPicProgressView.setRadius(15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.d);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131440242);
        ((RelativeLayout)paramImageFileHolder.j).addView(localPicProgressView, (ViewGroup.LayoutParams)localObject);
        localPicProgressView.setProgress(0);
        paramImageFileHolder.c = localPicProgressView;
        localPicProgressView = paramImageFileHolder.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramImageFileHolder.q.frienduin);
        ((StringBuilder)localObject).append(paramImageFileHolder.q.uniseq);
        localPicProgressView.setProgressKey(((StringBuilder)localObject).toString());
      }
      else
      {
        paramImageFileHolder.c.setProgress(paramInt);
      }
      paramImageFileHolder.c.setVisibility(0);
      return;
    }
    if (paramImageFileHolder.c != null)
    {
      localPicProgressView = paramImageFileHolder.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramImageFileHolder.q.frienduin);
      ((StringBuilder)localObject).append(paramImageFileHolder.q.uniseq);
      localPicProgressView.b(((StringBuilder)localObject).toString());
      localPicProgressView = paramImageFileHolder.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramImageFileHolder.q.frienduin);
      ((StringBuilder)localObject).append(paramImageFileHolder.q.uniseq);
      if (!localPicProgressView.c(((StringBuilder)localObject).toString()))
      {
        ((RelativeLayout)paramImageFileHolder.j).removeView(paramImageFileHolder.c);
        paramImageFileHolder.c = null;
        return;
      }
      paramImageFileHolder.c.setProgress(100);
    }
  }
  
  private void a(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, GuildMsgItemLayout paramGuildMsgItemLayout, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    if (paramImageFileHolder.e != null) {
      paramImageFileHolder.e.setVisibility(8);
    }
    b(paramImageFileHolder, paramFileManagerEntity);
    paramImageFileHolder.i.setVisibility(8);
    Object localObject = a(paramImageFileHolder, paramFileManagerEntity);
    paramImageFileHolder.b.setImageDrawable((Drawable)localObject);
    localObject = FileUtils.getFileSize(paramFileManagerEntity.fileSize);
    a(paramFileManagerEntity.fileName, (String)localObject, paramImageFileHolder);
    b(paramImageFileHolder, paramGuildMsgItemLayout, paramFileManagerEntity, paramChatMessage);
  }
  
  private void a(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = FileManagerUtil.w(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramImageFileHolder.g = i;
      paramImageFileHolder.h = j;
      paramFileManagerEntity.imgWidth = i;
      paramFileManagerEntity.imgHeight = j;
    }
    b(paramImageFileHolder, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, GuildImageFileBuilder.ImageFileHolder paramImageFileHolder)
  {
    if (paramImageFileHolder.d != null)
    {
      paramImageFileHolder.d.removeAllViews();
      ((RelativeLayout)paramImageFileHolder.j).removeView(paramImageFileHolder.d);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.b);
    localRelativeLayout.setId(2131433127);
    localRelativeLayout.setBackgroundResource(2130839253);
    paramImageFileHolder.d = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, this.b.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131440242);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131440242);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131440242);
    ((RelativeLayout)paramImageFileHolder.j).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = QFileUtils.a(paramImageFileHolder.g, paramImageFileHolder.h);
    localObject1 = new TextView(this.b);
    ((TextView)localObject1).setId(2131430544);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(7.0F, this.b.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(7.0F, this.b.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(7.0F, this.b.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
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
    localRelativeLayout.addView((View)localObject2, localLayoutParams);
    paramString1 = QFileUtils.a(this.b, i, paramImageFileHolder.g, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
    if (i != 1)
    {
      if (i == 2)
      {
        ((TextView)localObject2).setLines(1);
        ((TextView)localObject2).setMaxLines(1);
        ((TextView)localObject1).setGravity(5);
      }
    }
    else
    {
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
    }
    ((TextView)localObject2).setText(paramString1);
    ((TextView)localObject1).setText(paramString2);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    if (QQFileManagerUtil.v(paramFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new GuildImageFileBuilder.3(this, paramFileManagerEntity));
      return;
    }
    this.q.l();
  }
  
  private void b(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    String str = paramFileManagerEntity.strMiddleThumPath;
    paramFileManagerEntity = FilePicURLDrawlableHelper.a(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight, str);
    int i = paramFileManagerEntity.a;
    int j = paramFileManagerEntity.b;
    if ((i > 0) && (j > 0))
    {
      paramImageFileHolder.g = i;
      paramImageFileHolder.h = j;
    }
    else
    {
      paramImageFileHolder.g = this.l;
      paramImageFileHolder.h = this.m;
    }
    paramFileManagerEntity = paramImageFileHolder.b.getLayoutParams();
    if (paramFileManagerEntity == null)
    {
      paramFileManagerEntity = new RelativeLayout.LayoutParams(paramImageFileHolder.g, paramImageFileHolder.h);
      paramImageFileHolder.b.setLayoutParams(paramFileManagerEntity);
      return;
    }
    if ((paramFileManagerEntity.width != paramImageFileHolder.g) || (paramFileManagerEntity.height != paramImageFileHolder.h))
    {
      paramFileManagerEntity.width = paramImageFileHolder.g;
      paramFileManagerEntity.height = paramImageFileHolder.h;
      paramImageFileHolder.b.setLayoutParams(paramFileManagerEntity);
    }
  }
  
  private void b(GuildImageFileBuilder.ImageFileHolder paramImageFileHolder, GuildMsgItemLayout paramGuildMsgItemLayout, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    this.q.x().a(paramImageFileHolder, paramGuildMsgItemLayout, paramChatMessage);
    int j = paramFileManagerEntity.status;
    int i;
    if (this.q.i() == 6) {
      i = 1;
    } else {
      i = 0;
    }
    int k = (int)(paramFileManagerEntity.fProgress * 100.0F);
    if ((j != 16) && (i == 0))
    {
      if (j == 2)
      {
        a(paramImageFileHolder, k, true);
        paramImageFileHolder.i.setVisibility(8);
        return;
      }
      if ((j != 2) && (j != 4))
      {
        a(paramImageFileHolder, k, false);
        return;
      }
      a(paramImageFileHolder, k, false);
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.q.h()))
    {
      b(paramImageFileHolder, paramFileManagerEntity);
      a(paramImageFileHolder);
      paramImageFileHolder.i.setVisibility(8);
      if (paramImageFileHolder.d != null)
      {
        paramImageFileHolder.d.removeAllViews();
        ((RelativeLayout)paramImageFileHolder.j).removeView(paramImageFileHolder.d);
      }
    }
  }
  
  private Drawable c()
  {
    if (this.n == null)
    {
      float f = this.p;
      this.n = new AIOFilePicMask(Color.argb(255, 242, 242, 242), 255, f * 8.0F);
    }
    return this.n;
  }
  
  private void g(View paramView)
  {
    ChatMessage localChatMessage = ((BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView)).q;
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.b, paramView, localChatMessage, this.c, false, false);
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.q.b(paramChatMessage);
    GuildImageFileBuilder.ImageFileHolder localImageFileHolder = (GuildImageFileBuilder.ImageFileHolder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.b);
      paramView = new BubbleImageView(this.b);
      int i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.w = true;
      }
      paramView.setId(2131440242);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.c(false);
      paramView.setShowEdge(true);
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localImageFileHolder.b = paramView;
      paramView = new FrameLayout(this.b);
      Object localObject1 = new TextView(this.b);
      ((TextView)localObject1).setId(2131435900);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setTextColor(Color.rgb(178, 182, 195));
      Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramView.setVisibility(8);
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
      localImageFileHolder.e = paramView;
      paramView = new LinearLayout(this.b);
      paramView.setOrientation(1);
      paramView.setGravity(1);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localImageFileHolder.i = paramView;
      localObject1 = new ImageView(this.b);
      ((ImageView)localObject1).setImageResource(2130839585);
      paramView.addView((View)localObject1, new LinearLayout.LayoutParams(AIOUtils.b(20.0F, this.b.getResources()), AIOUtils.b(20.0F, this.b.getResources())));
      localObject1 = new TextView(this.b);
      ((TextView)localObject1).setText(2131889390);
      ((TextView)localObject1).setTextSize(12.0F);
      ((TextView)localObject1).setTextColor(Color.parseColor("#B0B3BF"));
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(8.0F, this.b.getResources());
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
    }
    localImageFileHolder.j = paramViewHolder;
    a(localImageFileHolder, paramGuildMsgItemLayout, FileManagerUtil.a(this.g, (MessageForFile)paramChatMessage), paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildImageFileBuilder.ImageFileHolder(null);
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
      DialogUtil.a(this.b, 230, str1, str2, new GuildImageFileBuilder.1(this), new GuildImageFileBuilder.2(this)).show();
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
    if (paramView.getId() == 2131430578)
    {
      g(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildImageFileBuilder
 * JD-Core Version:    0.7.0.1
 */