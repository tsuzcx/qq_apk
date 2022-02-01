package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class ForwardFileOption
  extends ForwardFileBaseOption
{
  private static FileManagerEntity ap;
  private static ChatMessage aq;
  boolean a = false;
  protected boolean ak;
  boolean al = false;
  boolean am = false;
  boolean an = false;
  private boolean ao;
  private ImageView ar;
  private PopupWindow as;
  private TextView at = null;
  private ForwardNewVersionDialog au;
  private SparseIntArray av;
  private EditText aw;
  private TextView ax;
  private EditText ay;
  
  public ForwardFileOption(Intent paramIntent)
  {
    super(paramIntent);
    this.L = 10;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 10000;
    int i = j;
    if (paramFileManagerEntity != null)
    {
      i = j;
      switch (paramFileManagerEntity.getCloudType())
      {
      case 4: 
      default: 
        i = j;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[");
          localStringBuilder.append(paramFileManagerEntity.getCloudType());
          QLog.e("dataline", 2, localStringBuilder.toString());
          return 10000;
        }
        break;
      case 8: 
        return 10011;
      case 6: 
      case 7: 
        if (FileUtil.b(paramFileManagerEntity.getFilePath())) {
          return 10000;
        }
        return 10009;
      case 2: 
        return 10003;
      case 1: 
        i = 10002;
      }
    }
    return i;
  }
  
  private View.OnTouchListener a(View paramView)
  {
    return new ForwardFileOption.9(this, paramView);
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    ap = paramFileManagerEntity;
    aq = paramChatMessage;
    paramChatMessage = new ForwardFileInfo();
    paramChatMessage.b(a(paramFileManagerEntity));
    paramChatMessage.d(paramFileManagerEntity.getCloudType());
    paramChatMessage.b(paramFileManagerEntity.nSessionId);
    paramChatMessage.c(paramFileManagerEntity.uniseq);
    paramChatMessage.d(paramFileManagerEntity.fileName);
    paramChatMessage.d(paramFileManagerEntity.fileSize);
    paramChatMessage.a(paramFileManagerEntity.getFilePath());
    paramChatMessage.c(paramFileManagerEntity.WeiYunFileId);
    if (!TextUtils.isEmpty(paramFileManagerEntity.strLargeThumPath)) {
      paramChatMessage.f(paramFileManagerEntity.strLargeThumPath);
    } else if (!TextUtils.isEmpty(paramFileManagerEntity.strMiddleThumPath)) {
      paramChatMessage.f(paramFileManagerEntity.strMiddleThumPath);
    } else {
      paramChatMessage.f(paramFileManagerEntity.strThumbPath);
    }
    if (paramFileManagerEntity.Uuid != null) {
      paramChatMessage.b(paramFileManagerEntity.Uuid);
    }
    if (paramFileManagerEntity.TroopUin != 0L) {
      paramChatMessage.a(paramFileManagerEntity.TroopUin);
    }
    if (paramFileManagerEntity.strTroopFileID != null) {
      paramChatMessage.e(paramFileManagerEntity.strTroopFileID);
    }
    return paramChatMessage;
  }
  
  private String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("photo/");
    ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      ImageUtil.a(this.q.getApplication(), paramString, (String)localObject, 600, 800);
      return localObject;
    }
    catch (Exception paramString) {}
    return localObject;
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt1, 0, paramInt1);
    URLImageView localURLImageView = new URLImageView(this.s);
    localURLImageView.setId(2131433647);
    localURLImageView.setAdjustViewBounds(true);
    localURLImageView.setMaxHeight(ViewUtils.dip2px(140.0F));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject);
    localObject = new View(this.s);
    ((View)localObject).setId(2131433642);
    ((View)localObject).setBackgroundColor(Color.argb(0, 0, 0, 0));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, 2131433647);
    localLayoutParams.addRule(8, 2131433647);
    localLayoutParams.addRule(5, 2131433647);
    localLayoutParams.addRule(7, 2131433647);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.s);
    ((ImageView)localObject).setId(2131433648);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt2, paramInt2);
    localLayoutParams.addRule(13);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    paramRelativeLayout = aJ();
    if (paramRelativeLayout != null) {
      localURLImageView.setImageDrawable(paramRelativeLayout);
    }
    ((ImageView)localObject).setImageResource(2130840439);
  }
  
  private void a(int paramInt, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt, 0, paramInt);
    URLImageView localURLImageView = new URLImageView(this.s);
    localURLImageView.setId(2131433647);
    localURLImageView.setAdjustViewBounds(true);
    localURLImageView.setMaxHeight(ViewUtils.dip2px(140.0F));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramRelativeLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject);
    this.ar = localURLImageView;
    localObject = new View(this.s);
    ((View)localObject).setId(2131433642);
    ((View)localObject).setBackgroundColor(Color.argb(0, 0, 0, 0));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, 2131433647);
    localLayoutParams.addRule(8, 2131433647);
    localLayoutParams.addRule(5, 2131433647);
    localLayoutParams.addRule(7, 2131433647);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    paramRelativeLayout = aJ();
    if (paramRelativeLayout != null) {
      localURLImageView.setImageDrawable(paramRelativeLayout);
    }
  }
  
  private void a(int paramInt, RelativeLayout paramRelativeLayout, ImageView paramImageView, AsyncImageView paramAsyncImageView, LinearLayout paramLinearLayout1, TextView paramTextView, LinearLayout paramLinearLayout2)
  {
    ImageButton localImageButton = new ImageButton(this.s);
    localImageButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
    localImageButton.setImageResource(2130845720);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    paramLinearLayout1.addView(localImageButton, localLayoutParams);
    paramLinearLayout1.setGravity(16);
    localImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageButton.setPadding(0, 0, 0, 0);
    localLayoutParams.setMargins(0, 0, 0, 0);
    localImageButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
    paramRelativeLayout.setOnClickListener(null);
    paramRelativeLayout.setOnTouchListener(null);
    paramTextView.setOnClickListener(new ForwardFileOption.3(this));
    paramTextView.setOnTouchListener(new ForwardFileOption.4(this, localImageButton));
    localImageButton.setOnClickListener(new ForwardFileOption.5(this));
    localImageButton.setOnTouchListener(new ForwardFileOption.6(this, localImageButton));
    this.at.setOnClickListener(ay());
    paramAsyncImageView.setOnClickListener(ay());
    paramImageView.setOnClickListener(ay());
    this.at.setOnTouchListener(a(paramLinearLayout2));
    paramAsyncImageView.setOnTouchListener(a(paramLinearLayout2));
    paramImageView.setOnTouchListener(a(paramLinearLayout2));
  }
  
  private void a(ForwardFileInfo paramForwardFileInfo, int paramInt)
  {
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.d() != null) && (paramForwardFileInfo.d().length() > 1) && (paramInt != 1) && (paramInt != 0) && (paramInt != 2) && (paramForwardFileInfo.j() < 104857600L)) {
      this.an = true;
    }
    if ((paramForwardFileInfo == null) && (this.aj.length() > 1) && (this.ah.length() > 1) && (this.ai < 104857600L)) {
      this.an = true;
    }
  }
  
  private void a(ForwardFileInfo paramForwardFileInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setPadding(0, paramInt5, 0, paramInt5);
    ImageView localImageView = new ImageView(this.s);
    localImageView.setId(2131433641);
    localImageView.setImageResource(2130840437);
    Object localObject1 = new RelativeLayout.LayoutParams(paramInt2, paramInt3);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = paramInt1;
    paramRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
    AsyncImageView localAsyncImageView = new AsyncImageView(this.s);
    localAsyncImageView.setId(2131433643);
    Object localObject2 = new RelativeLayout.LayoutParams(paramInt6, paramInt6);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131433641);
    paramRelativeLayout.addView(localAsyncImageView, (ViewGroup.LayoutParams)localObject2);
    Object localObject3 = new LinearLayout(this.s);
    ((LinearLayout)localObject3).setId(2131433646);
    ((LinearLayout)localObject3).setOrientation(1);
    ((LinearLayout)localObject3).setBackgroundColor(Color.argb(0, 0, 0, 0));
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131433643);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    paramRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    this.at = new EllipsizingTextView(this.s, null);
    this.at.setId(2131433644);
    this.at.setMaxLines(1);
    this.at.setIncludeFontPadding(false);
    this.at.setLineSpacing(0.0F, 1.0F);
    this.at.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.at.setTextColor(Color.parseColor("#777777"));
    this.at.setTextSize(1, 14.0F);
    ((LinearLayout)localObject3).addView(this.at);
    localObject2 = new LinearLayout(this.s);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, paramInt4);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131433644);
    ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new TextView(this.s);
    ((TextView)localObject3).setId(2131433645);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setGravity(16);
    ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject3).setTextSize(1, 14.0F);
    ((LinearLayout)localObject2).addView((View)localObject3);
    SimpleModeHelper.a(this.at, (TextView)localObject3, localImageView, (ViewGroup.LayoutParams)localObject1);
    localObject4 = new LinearLayout(this.s);
    ((LinearLayout)localObject4).setId(2131433642);
    ((LinearLayout)localObject4).setOrientation(1);
    ((LinearLayout)localObject4).setBackgroundColor(Color.argb(0, 0, 0, 0));
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131433646);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131433646);
    paramRelativeLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
    if (paramForwardFileInfo != null) {
      localObject1 = paramForwardFileInfo.i();
    } else {
      localObject1 = this.aj;
    }
    long l;
    if (paramForwardFileInfo != null) {
      l = paramForwardFileInfo.j();
    } else {
      l = this.ai;
    }
    FileManagerUtil.a(localAsyncImageView, (String)localObject1);
    this.at.setText((CharSequence)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtil.a(l, this.s.getResources().getDisplayMetrics().densityDpi));
    localStringBuilder.append(" ");
    ((TextView)localObject3).setText(localStringBuilder.toString());
    a(paramForwardFileInfo, FileManagerUtil.c((String)localObject1));
    if (this.an)
    {
      aA();
      a(paramInt3, paramRelativeLayout, localImageView, localAsyncImageView, (LinearLayout)localObject2, (TextView)localObject3, (LinearLayout)localObject4);
    }
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 9501) {
      return false;
    }
    if ((paramRecentUser.getType() == 1006) && (!a(ForwardAbility.ForwardAbilityType.i))) {
      return false;
    }
    if (paramRecentUser.getType() == 6004) {
      return false;
    }
    return paramRecentUser.getType() != 7000;
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 544	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 546	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 544	java/io/File
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 546	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 11
    //   19: aconst_null
    //   20: astore 12
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore_2
    //   27: new 548	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 551	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokevirtual 555	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   38: astore_1
    //   39: new 557	java/io/FileOutputStream
    //   42: dup
    //   43: aload 11
    //   45: invokespecial 558	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokevirtual 559	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   51: astore 11
    //   53: aload_1
    //   54: invokevirtual 564	java/nio/channels/FileChannel:size	()J
    //   57: lstore 4
    //   59: iconst_0
    //   60: istore_3
    //   61: lconst_0
    //   62: lload 4
    //   64: lcmp
    //   65: ifge +43 -> 108
    //   68: iload_3
    //   69: i2l
    //   70: lstore 6
    //   72: aload_1
    //   73: lload 6
    //   75: lload 4
    //   77: aload 11
    //   79: invokevirtual 568	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   82: lstore 8
    //   84: lload 8
    //   86: lconst_0
    //   87: lcmp
    //   88: ifle -27 -> 61
    //   91: lload 6
    //   93: lload 8
    //   95: ladd
    //   96: l2i
    //   97: istore_3
    //   98: lload 4
    //   100: lload 8
    //   102: lsub
    //   103: lstore 4
    //   105: goto -44 -> 61
    //   108: aload_1
    //   109: ifnull +15 -> 124
    //   112: aload_1
    //   113: invokevirtual 571	java/nio/channels/FileChannel:close	()V
    //   116: goto +8 -> 124
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   124: aload 11
    //   126: ifnull +16 -> 142
    //   129: aload 11
    //   131: invokevirtual 571	java/nio/channels/FileChannel:close	()V
    //   134: goto +8 -> 142
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_2
    //   145: aload_1
    //   146: astore 10
    //   148: goto +94 -> 242
    //   151: astore 10
    //   153: aload 11
    //   155: astore_2
    //   156: goto +15 -> 171
    //   159: astore_2
    //   160: aload 12
    //   162: astore 10
    //   164: goto +85 -> 249
    //   167: astore 10
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_1
    //   172: astore 11
    //   174: aload_2
    //   175: astore_1
    //   176: aload 11
    //   178: astore_2
    //   179: goto +14 -> 193
    //   182: astore_1
    //   183: aconst_null
    //   184: astore 11
    //   186: goto +68 -> 254
    //   189: astore 10
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 10
    //   195: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   198: aload_2
    //   199: ifnull +15 -> 214
    //   202: aload_2
    //   203: invokevirtual 571	java/nio/channels/FileChannel:close	()V
    //   206: goto +8 -> 214
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   214: aload_1
    //   215: ifnull +14 -> 229
    //   218: aload_1
    //   219: invokevirtual 571	java/nio/channels/FileChannel:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore 12
    //   233: aload_2
    //   234: astore 10
    //   236: aload_1
    //   237: astore 11
    //   239: aload 12
    //   241: astore_2
    //   242: aload 10
    //   244: astore_1
    //   245: aload 11
    //   247: astore 10
    //   249: aload_1
    //   250: astore 11
    //   252: aload_2
    //   253: astore_1
    //   254: aload 11
    //   256: ifnull +16 -> 272
    //   259: aload 11
    //   261: invokevirtual 571	java/nio/channels/FileChannel:close	()V
    //   264: goto +8 -> 272
    //   267: astore_2
    //   268: aload_2
    //   269: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   272: aload 10
    //   274: ifnull +16 -> 290
    //   277: aload 10
    //   279: invokevirtual 571	java/nio/channels/FileChannel:close	()V
    //   282: goto +8 -> 290
    //   285: astore_2
    //   286: aload_2
    //   287: invokevirtual 574	java/io/IOException:printStackTrace	()V
    //   290: goto +5 -> 295
    //   293: aload_1
    //   294: athrow
    //   295: goto -2 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	ForwardFileOption
    //   0	298	1	paramString1	String
    //   0	298	2	paramString2	String
    //   60	38	3	i	int
    //   57	47	4	l1	long
    //   70	22	6	l2	long
    //   82	19	8	l3	long
    //   23	124	10	str	String
    //   151	1	10	localIOException1	java.io.IOException
    //   162	1	10	localObject1	Object
    //   167	1	10	localIOException2	java.io.IOException
    //   189	5	10	localIOException3	java.io.IOException
    //   234	44	10	localObject2	Object
    //   17	243	11	localObject3	Object
    //   20	141	12	localObject4	Object
    //   231	9	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   112	116	119	java/io/IOException
    //   129	134	137	java/io/IOException
    //   53	59	144	finally
    //   72	84	144	finally
    //   53	59	151	java/io/IOException
    //   72	84	151	java/io/IOException
    //   39	53	159	finally
    //   39	53	167	java/io/IOException
    //   27	39	182	finally
    //   27	39	189	java/io/IOException
    //   202	206	209	java/io/IOException
    //   218	222	224	java/io/IOException
    //   193	198	231	finally
    //   259	264	267	java/io/IOException
    //   277	282	285	java/io/IOException
  }
  
  private void aA()
  {
    if (this.av != null) {
      return;
    }
    this.av = new SparseIntArray();
    this.av.put(1, 2131896203);
    this.av.put(-1, 2131896197);
    this.av.put(-2, 2131896198);
    this.av.put(-3, 2131896195);
    this.av.put(-4, 2131896204);
    this.av.put(-5, 2131896201);
    this.av.put(-6, 2131896199);
    this.av.put(-7, 2131896202);
    this.av.put(-8, 2131896196);
  }
  
  private void aB()
  {
    PopupWindow localPopupWindow = this.as;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  private TextView.OnEditorActionListener aC()
  {
    return new ForwardFileOption.11(this);
  }
  
  private TextWatcher aD()
  {
    return new ForwardFileOption.12(this);
  }
  
  private View.OnLongClickListener aE()
  {
    return new ForwardFileOption.13(this);
  }
  
  private View.OnClickListener aF()
  {
    Object localObject1 = aK();
    String str;
    if (localObject1 != null) {
      str = ((ForwardFileInfo)localObject1).i();
    } else {
      str = this.aj;
    }
    if (localObject1 != null) {
      localObject1 = ((ForwardFileInfo)localObject1).d();
    } else {
      localObject1 = this.ah;
    }
    Object localObject2 = this.at;
    if (localObject2 != null) {
      localObject2 = ((TextView)localObject2).getText().toString();
    } else {
      localObject2 = "";
    }
    return new ForwardFileOption.14(this, str, (String)localObject1, h((String)localObject2));
  }
  
  private boolean aG()
  {
    int i = this.s.getWindow().getDecorView().getHeight();
    Rect localRect = new Rect();
    this.s.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return i * 3 / 4 > localRect.bottom;
  }
  
  private boolean aH()
  {
    if (!this.an) {
      return true;
    }
    if (this.t != null)
    {
      if (this.t.size() < 9) {
        return true;
      }
      if ((this.t.containsKey("fileinfo_array")) && (this.t.getParcelableArrayList("fileinfo_array").size() > 1)) {
        return true;
      }
      ForwardFileInfo localForwardFileInfo = aK();
      String str2 = this.at.getText().toString();
      String str1;
      if (localForwardFileInfo != null) {
        str1 = localForwardFileInfo.i();
      } else {
        str1 = this.aj;
      }
      if (str2.equals(str1)) {
        return true;
      }
      if (localForwardFileInfo != null) {
        str1 = localForwardFileInfo.d();
      } else {
        str1 = this.ah;
      }
      int i = str1.lastIndexOf('/');
      Object localObject;
      if ((i > -1) && (i < str1.length()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1.substring(0, i + 1));
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      if (a(str1, (String)localObject))
      {
        if (localForwardFileInfo != null)
        {
          localForwardFileInfo.d(str2);
          localForwardFileInfo.a((String)localObject);
          localForwardFileInfo.b(10000);
          this.t.putParcelable("fileinfo", localForwardFileInfo);
        }
        this.t.putString("forward_filepath", (String)localObject);
        this.r.putExtras(this.t);
        return true;
      }
      g(-1);
      return false;
    }
    return true;
  }
  
  private int aI()
  {
    Object localObject = aK();
    int i = -1;
    if ((localObject == null) && (TextUtils.isEmpty(this.ah))) {
      return -1;
    }
    if ((localObject != null) || (!TextUtils.isEmpty(this.ah)))
    {
      if (localObject != null) {
        localObject = ((ForwardFileInfo)localObject).i();
      } else {
        localObject = this.ah;
      }
      String str = aw();
      i = FileManagerUtil.c((String)localObject);
      if ((i == 0) && (FileUtils.fileExistsAndNotEmpty(str))) {
        return 2;
      }
      if ((i == 2) && (FileUtils.fileExistsAndNotEmpty(str))) {
        return 3;
      }
      i = 1;
    }
    return i;
  }
  
  private Drawable aJ()
  {
    String str = aw();
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      return URLDrawable.getFileDrawable(str, localURLDrawableOptions);
    }
    return null;
  }
  
  private ForwardFileInfo aK()
  {
    if (this.ad != null) {
      return this.ad;
    }
    if ((this.ae != null) && (this.ae.size() == 1)) {
      return (ForwardFileInfo)this.ae.get(0);
    }
    return null;
  }
  
  private void aL()
  {
    Object localObject1 = aK();
    if (localObject1 != null)
    {
      int i = ((ForwardFileInfo)localObject1).c();
      if (((i == 10000) || (i == 10006)) && (aI() == 2))
      {
        b(au(), String.valueOf(((ForwardFileInfo)localObject1).b()));
        return;
      }
      long l1;
      Object localObject2;
      if ((i != 10000) && (i != 10001) && (i != 10002) && (i != 10004) && (i != 10003))
      {
        if (i == 10006)
        {
          l1 = ((ForwardFileInfo)localObject1).e();
          localObject2 = this.q.getFileManagerDataCenter().a(l1);
          if (localObject2 != null)
          {
            localObject2 = TroopFileUtils.a(this.q, (FileManagerEntity)localObject2);
            l1 = this.r.getLongExtra("last_time", 0L);
            String str = this.r.getStringExtra("sender_uin");
            i = FileManagerUtil.c(((TroopFileStatusInfo)localObject2).t);
            if ((i != 0) && (i != 2))
            {
              QFileUtils.a(this.q, this.s, null, (TroopFileStatusInfo)localObject2, str, l1, 12, false);
              return;
            }
            long l2 = ((ForwardFileInfo)localObject1).b();
            QFileUtils.a(this.q, this.s, null, null, l2, (TroopFileStatusInfo)localObject2, str, l1, -1, 12, null, false, false);
          }
        }
        else if (i == 10013)
        {
          l1 = this.r.getLongExtra("qfavId", -1L);
          if (l1 != -1L) {
            QfavHelper.a(this.s, "", l1);
          }
        }
      }
      else
      {
        l1 = ((ForwardFileInfo)localObject1).e();
        localObject1 = this.q.getFileManagerDataCenter().a(l1);
        if (localObject1 != null)
        {
          if ((((FileManagerEntity)localObject1).nFileType != 0) && (((FileManagerEntity)localObject1).nFileType != 2))
          {
            localObject1 = new FileModelAdapter(this.q, (FileManagerEntity)localObject1);
            localObject2 = new FileBrowserParam().a(12);
            ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.s, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
            return;
          }
          FileModel.a((FileManagerEntity)localObject1).a(this.s, i, 12);
        }
      }
    }
    else if (FileUtils.fileExistsAndNotEmpty(this.ah))
    {
      try
      {
        localObject1 = FileManagerUtil.a(new FileInfo(this.ah));
        if (localObject1 != null)
        {
          FileModel.a((FileManagerEntity)localObject1).a(this.s, 12);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private String au()
  {
    String str2;
    String str1;
    if (this.ad == null)
    {
      str2 = this.r.getStringExtra("forward_filepath");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.t.getString("forward_filepath");
      }
    }
    else
    {
      str2 = this.ad.d();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.ad.p();
      }
    }
    if (TextUtils.isEmpty(str1)) {
      return null;
    }
    int i = FileManagerUtil.c(str1);
    if ((i != -1) && (i != 11)) {
      return str1;
    }
    return a(str1);
  }
  
  private void av()
  {
    String str = au();
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      File localFile = new File(str);
      this.aj = localFile.getName();
      this.ah = str;
      this.ai = localFile.length();
    }
  }
  
  private String aw()
  {
    Object localObject = aK();
    if (localObject != null) {
      return ((ForwardFileInfo)localObject).p();
    }
    String str = this.r.getStringExtra("forward_thumb");
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.t.getString("forward_thumb");
    }
    return localObject;
  }
  
  @NotNull
  private View.OnTouchListener ax()
  {
    return new ForwardFileOption.7(this);
  }
  
  private View.OnClickListener ay()
  {
    return new ForwardFileOption.8(this);
  }
  
  private int az()
  {
    Object localObject = this.t;
    int i = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = this.t.getParcelableArrayList("forward_multi_target");
    if (localObject != null)
    {
      if (((List)localObject).size() > 1) {
        i = 4;
      }
    }
    else
    {
      int j = this.t.getInt("uintype", 0);
      if (j != -1)
      {
        if (j != 0)
        {
          if (j == 1) {
            i = 1;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 3;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800AEE9", "0X800AEE9", i, 0, "", "", "", "");
    return i;
  }
  
  public static ForwardFileInfo b(FileManagerEntity paramFileManagerEntity)
  {
    return a(paramFileManagerEntity, null);
  }
  
  private void b(View paramView)
  {
    if (this.as == null)
    {
      View localView = LayoutInflater.from(this.s).inflate(2131627078, null);
      this.as = new PopupWindow(localView, -1, -2, true);
      this.as.setContentView(localView);
      this.as.setSoftInputMode(16);
      this.aw = ((EditText)localView.findViewById(2131440500));
      this.ax = ((TextView)localView.findViewById(2131430471));
      this.aw.setSingleLine(false);
      this.aw.setMaxLines(2);
      this.aw.setOnEditorActionListener(aC());
      this.aw.setOnLongClickListener(aE());
      this.aw.addTextChangedListener(aD());
      this.ax.setOnClickListener(aF());
      this.ay = ((EditText)this.au.findViewById(2131435808));
      if (this.ay != null) {
        this.as.setOnDismissListener(new ForwardFileOption.10(this));
      }
    }
    c(paramView);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startToGalleryWithPath: path=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ForwardOption.ForwardFileOption", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new AIOImageData();
      ((AIOImageData)localObject).a = paramString1;
      ((AIOImageData)localObject).b = paramString1;
      ((AIOImageData)localObject).c = paramString1;
      ((AIOImageData)localObject).j = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      paramString1.putBoolean("key_allow_forward_photo_preview_edit", true);
      a(paramString1, new AIOImageProviderService(this.q.getCurrentUin(), paramString2, 0, null), (AIORichMediaData)localObject);
      aq();
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = this.aw;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((EditText)localObject1).getText().toString();
    this.aw.setSelection(((String)localObject1).length());
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      if (!((String)localObject1).matches("[^/\\\\\\\\<>*:?|\\\"]+"))
      {
        g(-7);
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramString3);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString3 = this.at;
      localObject1 = "";
      if (paramString3 != null) {
        paramString3 = paramString3.getText().toString();
      } else {
        paramString3 = "";
      }
      if (((String)localObject2).equals(paramString3))
      {
        ReportController.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
        aB();
        return;
      }
      if (!((String)localObject2).equals(paramString1))
      {
        int j = paramString2.lastIndexOf('/');
        int i = 0;
        paramString1 = (String)localObject1;
        if (j > -1)
        {
          paramString1 = (String)localObject1;
          if (j < paramString2.length()) {
            paramString1 = paramString2.substring(0, j + 1);
          }
        }
        paramString1 = new File(paramString1).listFiles();
        if ((paramString1 != null) && (paramString1.length > 0))
        {
          j = paramString1.length;
          while (i < j)
          {
            paramString2 = paramString1[i];
            if ((!paramString2.isDirectory()) && (paramString2.getName().toLowerCase().equals(((String)localObject2).toLowerCase())))
            {
              g(-3);
              return;
            }
            i += 1;
          }
        }
      }
      paramString1 = this.at;
      if (paramString1 != null) {
        paramString1.setText((CharSequence)localObject2);
      }
      g(1);
      ReportController.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
      aB();
      return;
    }
    g(-6);
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() != 1) || (c(paramRecentUser.uin))) && ((paramRecentUser.getType() != 0) || (CrmUtils.a(this.q, paramRecentUser.uin, paramRecentUser.getType()))) && (paramRecentUser.getType() != 3000))
    {
      if (-1L != FileManagerUtil.f(paramRecentUser.getType())) {
        return true;
      }
      return (paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.g)) && (as());
    }
    return true;
  }
  
  private void c(View paramView)
  {
    if (this.as == null) {
      return;
    }
    this.am = false;
    Object localObject = this.ay;
    if (localObject != null) {
      ((EditText)localObject).setFocusable(false);
    }
    localObject = (InputMethodManager)this.s.getSystemService("input_method");
    ((InputMethodManager)localObject).toggleSoftInput(1000, 2);
    this.as.setFocusable(true);
    this.as.setOutsideTouchable(true);
    this.as.update();
    this.as.setBackgroundDrawable(new BitmapDrawable());
    this.as.showAtLocation(paramView.getRootView(), 80, 0, 0);
    if (aG()) {
      ((InputMethodManager)localObject).toggleSoftInput(0, 2);
    }
    paramView = this.au;
    if (paramView != null) {
      paramView.a();
    }
    this.aw.setFocusable(true);
    this.aw.setFocusableInTouchMode(true);
    this.aw.requestFocus();
  }
  
  private boolean c(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() != 0) || (CrmUtils.a(this.q, paramRecentUser.uin, paramRecentUser.getType()))) && (paramRecentUser.getType() != 1) && (paramRecentUser.getType() != 3000) && (paramRecentUser.getType() != 1006) && (paramRecentUser.getType() != 1004))
    {
      if (paramRecentUser.getType() == 1000) {
        return true;
      }
      return (paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.g)) && (as());
    }
    return true;
  }
  
  private boolean d(RecentUser paramRecentUser)
  {
    return paramRecentUser.getType() == 1;
  }
  
  private boolean e(RecentUser paramRecentUser)
  {
    if (!Utils.b(paramRecentUser.uin))
    {
      if (((paramRecentUser.getType() == 0) && (!CrmUtils.a(this.q, paramRecentUser.uin, paramRecentUser.getType()))) || ((paramRecentUser.getType() == 1) && (a(d)) && (!c(paramRecentUser.uin))) || (paramRecentUser.getType() == 3000) || (FileManagerUtil.f(paramRecentUser.getType()) != -1L)) {
        return true;
      }
    }
    else if ((paramRecentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN)) && (a(ForwardAbility.ForwardAbilityType.g)) && (as())) {
      return true;
    }
    return false;
  }
  
  private boolean f(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 0) || (paramInt == 7) || (paramInt == 6) || (paramInt == 10) || (paramInt == 9);
  }
  
  private int g(int paramInt)
  {
    SparseIntArray localSparseIntArray = this.av;
    int i;
    if (localSparseIntArray != null) {
      i = localSparseIntArray.get(paramInt, 0);
    } else {
      i = 0;
    }
    if (paramInt == 1) {
      paramInt = 2;
    } else if (paramInt == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    QQToast.makeText(this.s, paramInt, i, 0).show();
    return paramInt;
  }
  
  private String h(String paramString)
  {
    Object localObject1 = this.aw;
    Object localObject2 = "";
    if (localObject1 == null) {
      return "";
    }
    localObject1 = ".rename";
    String str;
    if (paramString.endsWith(".rename") == true)
    {
      str = paramString.replace(".rename", "");
      paramString = (String)localObject1;
      localObject1 = str;
    }
    else
    {
      str = "";
      localObject1 = paramString;
      paramString = str;
    }
    int i = ((String)localObject1).lastIndexOf('.');
    if ((i > -1) && (i < ((String)localObject1).length()))
    {
      localObject2 = ((String)localObject1).substring(0, i);
      this.aw.setText((CharSequence)localObject2);
      this.aw.setSelection(((String)localObject2).length());
      localObject1 = ((String)localObject1).substring(i, ((String)localObject1).length());
    }
    else
    {
      this.aw.setText((CharSequence)localObject1);
      this.aw.setSelection(((String)localObject1).length());
      localObject1 = localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  protected void Z()
  {
    this.as = null;
    this.au = new ForwardNewVersionDialog(this.s);
    this.au.a(2131627070);
    Object localObject = this.au;
    this.A = ((QQCustomDialog)localObject);
    ((ForwardNewVersionDialog)localObject).a(G() ^ true);
    this.au.c(210);
    this.au.a(a());
    this.au.setCanceledOnTouchOutside(false);
    this.au.a(B(), H(), this.s.getResources().getString(C()), this.s.getResources().getString(D()), N(), P());
    a(this.au);
    localObject = this.au.getWindow();
    ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (!this.s.isFinishing()) {
      this.au.show();
    }
    this.A.setOnDismissListener(this);
  }
  
  protected View a()
  {
    Object localObject = aK();
    int i = AIOUtils.b(8.0F, this.s.getResources());
    int j = AIOUtils.b(12.0F, this.s.getResources());
    AIOUtils.b(14.0F, this.s.getResources());
    int k = AIOUtils.b(15.0F, this.s.getResources());
    int m = AIOUtils.b(16.0F, this.s.getResources());
    int n = AIOUtils.b(18.0F, this.s.getResources());
    int i1 = AIOUtils.b(20.0F, this.s.getResources());
    int i2 = AIOUtils.b(32.0F, this.s.getResources());
    int i3 = AIOUtils.b(40.0F, this.s.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.s);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localRelativeLayout.setOnClickListener(new ForwardFileOption.2(this));
    localRelativeLayout.setOnTouchListener(ax());
    localRelativeLayout.setLayoutParams(localLayoutParams);
    int i4 = aI();
    if (i4 == 2)
    {
      a(k, localRelativeLayout);
      return localRelativeLayout;
    }
    if (i4 == 3)
    {
      a(k, i3, localRelativeLayout);
      return localRelativeLayout;
    }
    if (i4 == 1)
    {
      a((ForwardFileInfo)localObject, i, j, m, n, i1, i2, localRelativeLayout);
      return localRelativeLayout;
    }
    localRelativeLayout.setPadding(0, i1, 0, i1);
    localObject = new AnimationTextView(this.s);
    ((AnimationTextView)localObject).setText(n());
    ((AnimationTextView)localObject).setMaxLines(2);
    ((AnimationTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject).setTextColor(this.s.getResources().getColorStateList(2131166157));
    ((AnimationTextView)localObject).setTextSize(14.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.bottomMargin = ScreenUtil.dip2px(10.0F);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localRelativeLayout.setOnClickListener(null);
    return localRelativeLayout;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.r.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (a(localRecentUser))) {
        if ((this.ak) && (b(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.ao) && (c(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.al) && (d(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if (e(localRecentUser)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      Object localObject = au();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh forward preview,editPicPath:");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" :currentFile");
        localStringBuilder.append((String)localObject);
        QLog.d("ForwardOption.ForwardFileOption", 2, localStringBuilder.toString());
      }
      if (!((String)localObject).equals(paramIntent))
      {
        this.w = false;
        this.t.remove("FORWARD_MSG_FOR_PIC");
        this.t.putString("forward_filepath", paramIntent);
        this.t.putString("forward_extra", paramIntent);
        this.t.putBoolean("extra_is_edited_pic", true);
        localObject = aK();
        if (localObject != null)
        {
          ((ForwardFileInfo)localObject).a(paramIntent);
          ((ForwardFileInfo)localObject).f(paramIntent);
        }
        paramIntent = aJ();
        if (paramIntent != null) {
          this.ar.setImageDrawable(paramIntent);
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.ak) && (!this.a) && (-1L != FileManagerUtil.f(paramBundle.getInt("uintype"))))
    {
      DialogUtil.a(this.s, 230, this.s.getString(2131895443), this.s.getString(2131895396), null, this.s.getString(2131917392), new ForwardFileOption.1(this), null).show();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList1 = this.t.getParcelableArrayList("fileinfo_array");
    Object localObject1 = null;
    if (localArrayList1 != null) {}
    try
    {
      localArrayList1 = (ArrayList)localArrayList1;
    }
    catch (ClassCastException localClassCastException)
    {
      label29:
      ArrayList localArrayList2;
      Object localObject2;
      int i;
      break label29;
    }
    localArrayList1 = null;
    localArrayList2 = (ArrayList)this.t.get("android.intent.extra.STREAM");
    if (localArrayList2.size() > 1)
    {
      if (localArrayList1 == null)
      {
        localObject2 = new ArrayList();
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localArrayList2.size()) {
            break;
          }
          localObject1 = (Uri)localArrayList2.get(i);
          ((ArrayList)localObject2).add(a(this.s, (Uri)localObject1));
          i += 1;
        }
      }
    }
    else
    {
      if (!aH()) {
        return;
      }
      localObject2 = aK();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(((ForwardFileInfo)localObject2).d());
      }
    }
    paramIntent.putExtra("dataline_forward_type", 100);
    paramIntent.putExtra("sendMultiple", true);
    if (localArrayList1 == null) {
      paramIntent.putStringArrayListExtra("dataline_forward_pathlist", (ArrayList)localObject1);
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        int k = FileManagerUtil.c(au());
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.b(localDeviceInfo.productId);
        if (((k != 2) || (!localSmartDeviceProxyMgr.c(localDeviceInfo.din)) || (!localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17))) && (localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (a(k))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b(Intent paramIntent)
  {
    if (!aH()) {
      return;
    }
    paramIntent.putExtra("dataline_forward_type", 100);
    if (this.ad == null)
    {
      String str2 = this.r.getStringExtra("forward_filepath");
      String str1 = str2;
      if (str2 == null) {
        str1 = this.t.getString("forward_filepath");
      }
      paramIntent.putExtra("dataline_forward_path", str1);
      return;
    }
    paramIntent.putExtra("dataline_forward_path", this.ad.d());
  }
  
  protected void c()
  {
    if ((!this.al) && (ai()))
    {
      this.C.add(c);
      this.C.add(j);
    }
    if ((!this.al) && (ag())) {
      this.C.add(e);
    }
    if ((this.ad != null) && (this.ad.c() != 10006) && (this.ad.c() != 10003) && (this.ad.c() != 10002)) {
      this.ad.c();
    }
    if (ah()) {
      this.C.add(d);
    }
    if (this.ad != null)
    {
      if (DataLineHandler.b(this.q.getFileManagerDataCenter().a(this.ad.e())))
      {
        this.C.add(g);
        this.C.add(l);
      }
    }
    else if (this.ae != null)
    {
      Iterator localIterator = this.ae.iterator();
      ForwardFileInfo localForwardFileInfo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localForwardFileInfo = (ForwardFileInfo)localIterator.next();
      } while ((localForwardFileInfo == null) || (!DataLineHandler.b(this.q.getFileManagerDataCenter().a(localForwardFileInfo.e()))));
      this.C.add(g);
      this.C.add(l);
    }
    else
    {
      this.C.add(g);
      this.C.add(l);
    }
    if ((this.r != null) && (this.r.getBooleanExtra("isFromFavorites", false))) {
      this.C.add(g);
    }
    if ((this.r != null) && (this.r.getBooleanExtra("k_smartdevice", true)) && (aj()) && (f(FileManagerUtil.c(au())))) {
      this.C.add(k);
    }
  }
  
  public boolean e()
  {
    super.e();
    Object localObject = this.r;
    boolean bool2 = false;
    this.J = ((Intent)localObject).getBooleanExtra("forward _key_nojump", false);
    if (this.ad != null)
    {
      int i = this.ad.o();
      localObject = this.ad.d();
      boolean bool3 = TextUtils.isEmpty((CharSequence)localObject);
      if (this.ad.c() == 10006) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.ak = bool1;
      if (this.ad.c() == 10009) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.al = bool1;
      if (i == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.ao = bool1;
      boolean bool1 = bool2;
      if ((bool3 ^ true)) {
        if (i != 3)
        {
          bool1 = bool2;
          if (!FileUtils.fileExists((String)localObject)) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.a = bool1;
    }
    else if (this.ae != null)
    {
      this.al = true;
      localObject = this.ae.iterator();
      ForwardFileInfo localForwardFileInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
      } while ((localForwardFileInfo == null) || (localForwardFileInfo.o() == 6));
      this.al = false;
    }
    else if (this.r.getBooleanExtra("isFromShare", false))
    {
      this.a = true;
    }
    this.t.putString("leftBackText", this.s.getString(2131917002));
    if ((this.ad == null) && (TextUtils.isEmpty(this.ah))) {
      av();
    }
    return true;
  }
  
  protected boolean f()
  {
    boolean bool = this.r.getBooleanExtra("isFromShare", false);
    if (!aH()) {
      return true;
    }
    Object localObject1;
    Intent localIntent;
    Object localObject2;
    if (K())
    {
      localObject1 = M();
      localIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fileoption realForwardTo isfromshare=");
        ((StringBuilder)localObject2).append(bool);
        QLog.d("forward", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        this.t.putString("leftBackText", HardCodeUtil.a(2131902749));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.t);
        bool = c(localIntent);
        if (this.K)
        {
          ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
          if ((QSecFramework.c().a(1003).booleanValue()) && (this.a))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ResultRecord)((Iterator)localObject1).next();
              SecShareInfoUtil.a().a(4, au(), ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).uin);
              SecShareInfoUtil.a().c();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
        }
      }
      else if (!this.J)
      {
        localIntent.putExtras(this.t);
        ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
      }
      localIntent.putExtras(this.t);
      this.s.setResult(-1, localIntent);
    }
    for (;;)
    {
      return false;
      int i = this.t.getInt("uintype");
      localObject1 = this.t.getString("uin");
      if (i == 1008)
      {
        localIntent = new Intent(this.s, ChatActivity.class);
        localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass((String)localObject1, this.q));
      }
      else
      {
        localIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fileoption realForwardTo isfromshare=");
        ((StringBuilder)localObject2).append(bool);
        QLog.d("forward", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        this.t.putString("leftBackText", HardCodeUtil.a(2131902748));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.t);
        bool = c(localIntent);
        if (this.K)
        {
          this.s.startActivity(localIntent);
          if ((QSecFramework.c().a(1003).booleanValue()) && (this.a))
          {
            SecShareInfoUtil.a().a(4, au(), i, (String)localObject1);
            SecShareInfoUtil.a().c();
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
        }
      }
      else if (!this.J)
      {
        localIntent.putExtras(this.t);
        ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
      }
      localIntent.putExtras(this.t);
      this.s.setResult(-1, localIntent);
      this.s.finish();
    }
  }
  
  protected void g()
  {
    String str1 = au();
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = this.t.getString("uin");
      int i = FileManagerUtil.c(str1);
      Object localObject;
      if (i == 2)
      {
        localObject = DeviceMsgHandle.b;
      }
      else
      {
        localObject = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.t.getString("uin")), 17)))
        {
          ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(str2), "", "", "", 0, null);
          if (i == 0)
          {
            super.a(str1, str2, "pic");
            return;
          }
          super.a(str1, str2, "file");
          return;
        }
        if (i == 0) {
          localObject = DeviceMsgHandle.d;
        } else {
          localObject = DeviceMsgHandle.b;
        }
      }
      DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localDeviceMsgHandle.b().a((String)localObject, str2, localArrayList, null);
    }
    this.s.finish();
  }
  
  protected int h()
  {
    FileManagerEntity localFileManagerEntity = ap;
    int i = 0;
    if (localFileManagerEntity != null)
    {
      if (new QfavBuilder(3).a(this.q, this.s, ap, aq, true))
      {
        ap = null;
        break label109;
      }
    }
    else if (this.ad != null)
    {
      localFileManagerEntity = this.q.getFileManagerDataCenter().a(this.ad.e());
      if ((localFileManagerEntity != null) && (new QfavBuilder(3).a(this.q, this.s, localFileManagerEntity, null, true)))
      {
        ap = null;
        break label109;
      }
    }
    i = -1;
    label109:
    if (i == 0) {
      QfavReport.a(this.q, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return i;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public boolean l()
  {
    return true;
  }
  
  protected String o()
  {
    return this.I.getString(2131916548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption
 * JD-Core Version:    0.7.0.1
 */