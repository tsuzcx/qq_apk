import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter.1;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class dy
  extends fa
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected LiteActivity a;
  protected QQAppInterface a;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c = -1;
  
  public dy(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dz(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296770);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296769);
    b();
  }
  
  private Drawable a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    int i;
    if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009))
    {
      i = 1;
      if (i != 0) {
        break label40;
      }
      paramDataLineMsgRecord = null;
    }
    for (;;)
    {
      return paramDataLineMsgRecord;
      i = 0;
      break;
      label40:
      Drawable localDrawable;
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        paramDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        localDrawable = paramDataLineMsgRecord.getDrawable(2130850006);
        paramDataLineMsgRecord = paramDataLineMsgRecord.getDrawable(2130849830);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDataLineMsgRecord;
      }
      while (bool)
      {
        return localDrawable;
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramDataLineMsgRecord = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
  }
  
  private void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (paramDrawable == null)
    {
      paramView.setBackgroundDrawable(null);
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  private void a(GridView paramGridView)
  {
    int i = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - agej.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(i);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(i));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ForwardFileOption.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10006);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ek paramek)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = lav.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((laq)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramek.jdField_a_of_type_Aqkt = aqlt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramek.jdField_a_of_type_Aqkt != null)
        {
          paramek.jdField_a_of_type_Aqkt.a(paramRelativeLayout, null);
          if (paramDataLineMsgRecord.msgtype == -1000) {
            break label333;
          }
        }
      }
    }
    label333:
    for (boolean bool = true;; bool = false)
    {
      int i = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        aogu.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramek.jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, gc.a(paramDataLineMsgRecord), i);
      if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2009))
      {
        localObject = a(paramDataLineMsgRecord);
        if (localObject != null) {
          a(paramRelativeLayout, (Drawable)localObject);
        }
      }
      if (paramDataLineMsgRecord.msgtype == -2000) {
        a(paramRelativeLayout, null);
      }
      if (paramDataLineMsgRecord.msgtype == -1000) {
        a(paramek, paramRelativeLayout, paramDataLineMsgRecord, paramek.jdField_a_of_type_Aqkt);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramek.jdField_a_of_type_Aqkt = aqlt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramek.jdField_a_of_type_Aqkt = aqlt.a(((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
    }
  }
  
  private void a(ek paramek, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838075), paramInt1, paramInt2, false);
        Object localObject1 = bhmq.a(localBitmap, agej.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
        localObject3 = localObject1;
        if (localBitmap != null) {}
        localObject3 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localBitmap.recycle();
          localObject3 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = new ClipDrawable(new BitmapDrawable(localObject3), 48, 2);
          paramek.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject2;
          break label104;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
      }
      label104:
      if (QLog.isColorLevel())
      {
        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
        localObject3 = localObject2;
      }
    }
    paramek.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private boolean a(ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramek == null) {}
    do
    {
      return true;
      if (paramek.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        return false;
      }
    } while (paramDataLineMsgSet == null);
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null))
    {
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramek.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramek.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramek.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setText(aunj.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693399)))) {
        break label540;
      }
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramek.a().jdField_c_of_type_AndroidWidgetTextView.setText(fd.a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramek.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramek.a().e.setVisibility(0);
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693365);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844230);
      break;
      label492:
      paramek.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844230);
      break label128;
      label508:
      paramek.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844230);
      break label173;
      label524:
      paramek.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844230);
      break label218;
      label540:
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693303);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label578:
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692156);
      } else if (i == j) {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + j);
      } else {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      }
    }
    label709:
    paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ForwardFileOption.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10002);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() == 0);
  }
  
  private boolean b(ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramek == null) {
      return true;
    }
    if (paramek.a().jdField_a_of_type_AndroidWidgetTextView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int j = paramDataLineMsgSet.getCompletedCount();
    int i = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    ed localed;
    label149:
    label314:
    if (j == i)
    {
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + i);
      j = ((Integer)paramek.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localed = (ed)paramek.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localed != null) {
        break label448;
      }
      localed = new ed(this, paramek, paramDataLineMsgSet, j, null);
      paramek.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localed);
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label502;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label468;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693365);
      label228:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramek.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label535;
          }
          paramek.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramek.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramek.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label550;
          }
          paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramek.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramDataLineMsgSet = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693348), new Object[] { Integer.valueOf(i) });
        paramek.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramDataLineMsgSet);
      }
      return true;
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setText(j + "/" + i);
      break;
      label448:
      localed.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localed.jdField_a_of_type_Ek = paramek;
      localed.a();
      break label149;
      label468:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label228;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131692156);
      break label228;
      label502:
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label228;
      label535:
      paramek.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label314;
      label550:
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramek == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    } while (localDataLineMsgRecord == null);
    String str = aunz.c(localDataLineMsgRecord.path);
    paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramek.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    label317:
    if ((str != null) && (new VFSFile(str).exists()))
    {
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(str);
      label125:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label483;
      }
      paramek.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label468;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131693318);
      label231:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramek.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label541;
          }
          paramek.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramek.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramek.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label556;
          }
          paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramek.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramek.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131701657));
      }
      if (paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        break;
      }
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(anzj.a(2131701649));
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label125;
      }
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label125;
      label468:
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label231;
      label483:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramek.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramek.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label231;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label231;
      label541:
      paramek.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label317;
      label556:
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramek == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramek.jdField_a_of_type_AndroidWidgetImageView.setTag(paramek);
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramek.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramek.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramek.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramek.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getTime();
  }
  
  protected View a(int paramInt, ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  protected void a(int paramInt, ek paramek, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    Object localObject = null;
    if (paramListView == null) {}
    int i;
    DataLineMsgSet localDataLineMsgSet;
    int j;
    label168:
    label379:
    do
    {
      float f;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
              } while (i == -1);
              paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
            } while ((paramListView == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()));
            localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
            if (localDataLineMsgSet.mUpdateProcessTick == 0L) {}
            for (localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();; localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis())
            {
              if (!localDataLineMsgSet.isSingle()) {
                break label379;
              }
              j = DataLineMsgRecord.getDevTypeBySeId(paramLong);
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j).a(paramLong);
              if (localObject == null) {
                break;
              }
              if (!a(getItemViewType(i))) {
                break label168;
              }
              a((DataLineMsgRecord)localObject, paramListView, paramFloat);
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break;
              }
            }
            f = paramFloat;
            if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
              f = ((DataLineMsgRecord)localObject).progress;
            }
            switch (((DataLineMsgRecord)localObject).msgtype)
            {
            default: 
              return;
            case -2335: 
            case -2009: 
            case -2005: 
              if (!((DataLineMsgRecord)localObject).bIsMoloImage) {
                break label272;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131368335);
            }
          } while (paramListView == null);
          paramListView.setProgress((int)(f * 100.0F));
          return;
          localObject = (TextView)paramListView.findViewById(2131366645);
          paramListView = (ProgressBar)paramListView.findViewById(2131366616);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131368335);
      } while (paramListView == null);
      paramListView.setProgress((int)(f * 100.0F));
      return;
      paramListView = (ek)paramListView.getTag();
    } while (paramListView == null);
    label272:
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label442:
      i = localDataLineMsgSet.getCompletedCount();
      j = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i != j) {
          break label542;
        }
        ((TextView)localObject).setText("" + j);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i != j) {
        break label576;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label442;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label442;
      label542:
      ((TextView)localObject).setText(i + "/" + j);
    }
    label576:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat) {}
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
  }
  
  protected void a(ek paramek, View paramView, DataLineMsgRecord paramDataLineMsgRecord, aqkt paramaqkt)
  {
    if (paramaqkt == null) {
      return;
    }
    if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()))
    {
      paramaqkt = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramaqkt.getColorStateList(2131167013);
        paramek.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramaqkt.getColorStateList(2131167012);; paramView = paramaqkt.getColorStateList(2131167011))
      {
        paramek.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramaqkt.getColorStateList(2131167009);
        break;
      }
    }
    if (paramaqkt.jdField_b_of_type_Int == 0) {
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramaqkt.c == 0)
    {
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167011));
      return;
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
    }
    paramek.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqkt.c);
  }
  
  protected void a(ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramek == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    aunj.a(paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramek.a().jdField_a_of_type_AndroidWidgetTextView.setText(aunj.d(paramDataLineMsgSet.filename));
    paramek.a().jdField_c_of_type_AndroidWidgetTextView.setText(fd.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693365);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692155);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692153);
        } else {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692154);
        }
      }
      else
      {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693365);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692156);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692147);
        } else if (!paramDataLineMsgSet.issuc) {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692153);
        } else {
          paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        }
      }
    }
    paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).b(paramLong);
    if (b()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
    if (i == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
    if (localView == null) {
      return false;
    }
    if (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) {
      return false;
    }
    paramListView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick != 0L) {
        break label138;
      }
    }
    for (paramListView.mUpdateMutiViewTick = System.currentTimeMillis(); paramListView.isSingle(); paramListView.mUpdateMutiViewTick = System.currentTimeMillis())
    {
      return true;
      label138:
      if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
        return true;
      }
    }
    localObject = (ek)localView.getTag();
    if (localObject == null) {
      return false;
    }
    switch (paramListView.getGroupType())
    {
    }
    do
    {
      do
      {
        do
        {
          d((ek)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((ek)localObject, paramListView));
        return false;
      } while (a((ek)localObject, paramListView));
      return false;
    } while (b((ek)localObject, paramListView));
    return false;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
  }
  
  protected void b(ek paramek, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramek == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null)
    {
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setText(aunj.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693399)))) {
        break label333;
      }
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label127:
      paramek.a().jdField_c_of_type_AndroidWidgetTextView.setText(fd.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label371;
      }
      paramek.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramek.a().e.setVisibility(0);
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label200:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label386;
      }
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label245:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label401;
      }
      paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693365);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label514;
      }
      paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramek.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844230);
      break;
      label333:
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramek.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693303);
      paramek.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label127;
      label371:
      paramek.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label200;
      label386:
      paramek.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label245;
      label401:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692156);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692147);
      } else if (!paramDataLineMsgSet.issuc) {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692153);
      } else {
        paramek.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
      }
    }
    label514:
    paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramek.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
  }
  
  public int getCount()
  {
    if (b()) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (b()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    if (b()) {
      paramInt = 13;
    }
    label137:
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      DataLineMsgSet localDataLineMsgSet;
      boolean bool;
      do
      {
        return paramInt;
        localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
        bool = localDataLineMsgSet.isSendFromLocal();
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          return 12;
        case -1000: 
          if (bool) {
            return 7;
          }
          return 0;
        case -2000: 
          if (!localDataLineMsgSet.isSingle()) {
            break label137;
          }
          paramInt = i;
        }
      } while (!bool);
      return 8;
      if (bool) {
        return 9;
      }
      return 2;
      if (localDataLineMsgSet.isSingle())
      {
        if (bool) {
          return 10;
        }
        return 3;
      }
      if (bool) {
        return 11;
      }
      return 4;
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (!localDataLineMsgSet.isSingle()) {
        break;
      }
      paramInt = i;
    } while (localDataLineMsgRecord.bIsMoloImage);
    return 5;
    if (localDataLineMsgRecord.bIsMoloImage) {
      return 2;
    }
    return 6;
    return 14;
    return 15;
    return 16;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (b()) {
      if (paramView == null)
      {
        localObject1 = new ek();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559065, null);
        localObject2 = (TextView)paramView.findViewById(2131370078);
        localObject3 = (ImageView)paramView.findViewById(2131370077);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject2).setText(2131691219);
          ((ImageView)localObject3).setImageResource(2130839558);
        }
        paramView.setTag(localObject1);
        paramView.setVisibility(4);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
        localObject1 = paramView;
      }
    }
    int i;
    DataLineMsgRecord localDataLineMsgRecord;
    label214:
    Object localObject4;
    int j;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (ek)paramView.getTag();
      break;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
      if (localObject3 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      else
      {
        i = getItemViewType(paramInt);
        localDataLineMsgRecord = ((DataLineMsgSet)localObject3).getFirstItem();
        if (paramView == null)
        {
          localObject2 = new ek();
          if (a(i))
          {
            paramView = a(i, (ek)localObject2, (DataLineMsgSet)localObject3);
            paramView.setTag(localObject2);
          }
        }
        for (localObject1 = localObject2;; localObject1 = (ek)paramView.getTag())
        {
          ((ek)localObject1).a((DataLineMsgSet)localObject3);
          if (i != 12) {
            break label3102;
          }
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
          break;
          if (i == 12)
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559053, null);
            ((ek)localObject2).b((TextView)((View)localObject1).findViewById(2131365287));
            paramView = (View)localObject1;
            if (((ek)localObject2).b() == null) {
              break label214;
            }
            ((ek)localObject2).b().setText(2131693356);
            paramView = (View)localObject1;
            break label214;
          }
          Object localObject5;
          if (i == 14)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559040, null);
            localObject1 = ((ek)localObject2).a();
            ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367669));
            localObject4 = anzj.a(2131701668);
            localObject5 = anzj.a(2131701645);
            ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
            localObject5 = new SpannableString("还想把文件发到好友手机？快来用\n" + (String)localObject4 + (String)localObject5);
            ((SpannableString)localObject5).setSpan(new ea(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + ((String)localObject4).length(), 33);
            ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
            ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject5);
            ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            break label214;
          }
          if (i == 15)
          {
            localObject1 = ((ek)localObject2).a();
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560942, null);
            ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367669));
            break label214;
          }
          if (i == 16)
          {
            localObject1 = ((ek)localObject2).a();
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558887, null);
            ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367669));
            ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(null);
            ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.getResources().getColorStateList(2131165428));
            break label214;
          }
          if (!((DataLineMsgSet)localObject3).isSendFromLocal())
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559054, null);
            localObject4 = (ImageView)((View)localObject1).findViewById(2131368212);
            paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844234);
            j = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject3);
            if (j == 0)
            {
              paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844234);
              label686:
              ((ImageView)localObject4).setImageDrawable(paramView);
              paramView = (View)localObject1;
              label695:
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371470));
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
              ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
              switch (i)
              {
              }
            }
          }
          for (;;)
          {
            ((ek)localObject2).a((ImageView)paramView.findViewById(2131366102));
            ((ek)localObject2).a((TextView)paramView.findViewById(2131365288));
            break;
            if (j != 1) {
              break label686;
            }
            paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844232);
            break label686;
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559060, null);
            break label695;
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559061, null);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378603));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(begp.a);
            if (((DataLineMsgSet)localObject3).isSendFromLocal()) {}
            for (localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167013);; localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009))
            {
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
              ((ek)localObject2).a((ProgressBar)paramView.findViewById(2131377364));
              if (((ek)localObject2).a() == null) {
                break;
              }
              ((ek)localObject2).a().setVisibility(8);
              break;
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559041, null);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368320));
            ((ek)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131368335));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376250));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377967));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364578));
            ((ek)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380282));
            if (!((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((ek)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380281));
              ((ek)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368252));
              ((ek)localObject2).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377859));
            }
            if (((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              ((ek)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
              a((ek)localObject2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              label1454:
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
              if (BaseBubbleBuilder.jdField_a_of_type_Boolean) {
                break label1579;
              }
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
            }
            for (;;)
            {
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131701655));
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(anzj.a(2131701663));
              break;
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              ((ek)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
              break label1454;
              label1579:
              localObject1 = new agxx(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
              ((ek)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
              j = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
              ((ek)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, j, -1);
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559043, null);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372656));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131372629));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366616));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377967));
            ((ek)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380282));
            if (!((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((ek)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380281));
              ((ek)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368252));
              ((ek)localObject2).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377859));
            }
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
            a(((ek)localObject2).a().jdField_a_of_type_AndroidWidgetGridView);
            continue;
            localObject4 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559036, null);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject4);
            if (anxh.a() > 17.0F)
            {
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
              j = agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
              localObject1 = (RelativeLayout)paramView.findViewById(2131366628);
              localObject5 = new RelativeLayout.LayoutParams(-1, j);
              ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131366631);
              ((RelativeLayout)localObject4).updateViewLayout((View)localObject1, (ViewGroup.LayoutParams)localObject5);
              localObject4 = (AsyncImageView)paramView.findViewById(2131366605);
              ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
              localObject5 = new RelativeLayout.LayoutParams(j, j);
              ((RelativeLayout.LayoutParams)localObject5).addRule(9, 2131366628);
              ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131366628);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131366640);
              ((TextView)localObject4).setGravity(16);
              localObject5 = new RelativeLayout.LayoutParams(-1, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131366605);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366628);
              ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131366628);
              ((RelativeLayout.LayoutParams)localObject5).setMargins(agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131366645);
              ((TextView)localObject4).setGravity(5);
              localObject5 = new RelativeLayout.LayoutParams(-2, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366628);
              ((RelativeLayout.LayoutParams)localObject5).addRule(12, 2131366628);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ek)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131366644);
              ((TextView)localObject4).setGravity(17);
              localObject5 = new RelativeLayout.LayoutParams(-2, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366628);
              ((RelativeLayout.LayoutParams)localObject5).addRule(2, 2131366645);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ek)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject4);
            }
            for (;;)
            {
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366616));
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130850750);
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
              break;
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
              ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366605));
              ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366640));
              ((ek)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366644));
              ((ek)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366645));
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559034, null);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366605));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366640));
            ((ek)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366619));
            ((ek)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366644));
            ((ek)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366645));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366616));
            ((ek)localObject2).a().e = ((TextView)paramView.findViewById(2131380281));
            ((ek)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368252));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377859));
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844229);
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            continue;
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559042, null);
            ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366606));
            ((ek)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366607));
            ((ek)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366608));
            ((ek)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366609));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366640));
            ((ek)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366619));
            ((ek)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366644));
            ((ek)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366645));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366616));
            ((ek)localObject2).a().e = ((TextView)paramView.findViewById(2131380281));
            ((ek)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368252));
            ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377859));
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844230);
            ((ek)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844230);
            ((ek)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844230);
            ((ek)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844230);
            ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((ek)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((ek)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((ek)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          }
        }
        label3102:
        if (i == 14)
        {
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject2 = (ascy)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361806);
            if (localObject2 != null)
            {
              i = aggu.a(((ascy)localObject2).getBitmap());
              ((ek)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(i));
            }
          }
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
        else if (i == 15)
        {
          localObject1 = ((ek)localObject1).a();
          localObject2 = aunj.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new eb(this, localDataLineMsgRecord));
          ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((er)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
        else
        {
          if (i != 16) {
            break label3394;
          }
          localObject2 = ((ek)localObject1).a();
          if ((localDataLineMsgRecord == null) || (TextUtils.isEmpty(localDataLineMsgRecord.msg)) || (((er)localObject2).jdField_a_of_type_AndroidWidgetTextView == null) || (localDataLineMsgRecord.msg.indexOf(anzj.a(2131701658)) < 0)) {
            break label3394;
          }
          localObject1 = aunj.a(localDataLineMsgRecord.msg, anzj.a(2131701646), new ec(this, localDataLineMsgRecord));
          ((er)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          ((er)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((er)localObject2).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
      }
    }
    label3394:
    switch (i)
    {
    }
    for (;;)
    {
      if (!a(i)) {
        break label3695;
      }
      a(i, (ek)localObject1, (DataLineMsgSet)localObject3);
      localObject2 = paramView;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      ((ek)localObject1).a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
      ((ek)localObject1).a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
      localObject2 = ((ek)localObject1).a().jdField_a_of_type_AndroidWidgetTextView;
      localObject4 = antf.z;
      localObject4 = new begp(localDataLineMsgRecord.msg, 13, 32, 6000);
      ((begp)localObject4).a("biz_src_jc_aio");
      ((TextView)localObject2).setText((CharSequence)localObject4);
      ((TextView)localObject2).setVisibility(0);
      if (((ek)localObject1).a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label3625;
        }
        ((ek)localObject1).a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject2).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
        break;
        label3625:
        ((ek)localObject1).a().setVisibility(8);
      }
      c((ek)localObject1, (DataLineMsgSet)localObject3);
      continue;
      b((ek)localObject1, (DataLineMsgSet)localObject3);
      continue;
      a((ek)localObject1, (DataLineMsgSet)localObject3);
      continue;
      b((ek)localObject1, (DataLineMsgSet)localObject3);
      continue;
      a((ek)localObject1, (DataLineMsgSet)localObject3);
    }
    label3695:
    a(localDataLineMsgRecord, ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout, (ek)localObject1);
    int k;
    int m;
    if (ThemeUtil.isDefaultTheme())
    {
      i = ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      j = ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight();
      k = ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
      m = ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom();
      if (!((DataLineMsgSet)localObject3).isSendFromLocal()) {
        ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), k, j, m);
      }
    }
    else
    {
      label3789:
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject2 = (ascy)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361806);
        if (localObject2 != null)
        {
          i = aggu.a(((ascy)localObject2).getBitmap());
          ((ek)localObject1).a().setTextColor(ColorStateList.valueOf(i));
        }
      }
      if (!a(((DataLineMsgSet)localObject3).getMsgId())) {
        break label3945;
      }
      localObject2 = bhsw.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject3).getTime() * 1000L);
      ((ek)localObject1).a().setVisibility(0);
      ((ek)localObject1).a().setText((CharSequence)localObject2);
    }
    for (;;)
    {
      d((ek)localObject1, (DataLineMsgSet)localObject3);
      localObject2 = paramView;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      ((ek)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, k, j + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), m);
      break label3789;
      label3945:
      ((ek)localObject1).a().setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 17;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dy
 * JD-Core Version:    0.7.0.1
 */