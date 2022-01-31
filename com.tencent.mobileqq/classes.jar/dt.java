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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class dt
  extends ev
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
  
  public dt(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new du(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296708);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296707);
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
        localDrawable = paramDataLineMsgRecord.getDrawable(2130849444);
        paramDataLineMsgRecord = paramDataLineMsgRecord.getDrawable(2130849268);
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
    int i = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - aepi.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
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
    paramDataLineMsgRecord = arzx.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10006);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ef paramef)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((ldm)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramef.jdField_a_of_type_Anwo = anxo.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramef.jdField_a_of_type_Anwo != null)
        {
          paramef.jdField_a_of_type_Anwo.a(paramRelativeLayout, null);
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
        amca.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramef.jdField_a_of_type_Anwo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, fx.a(paramDataLineMsgRecord), i);
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
        a(paramef, paramRelativeLayout, paramDataLineMsgRecord, paramef.jdField_a_of_type_Anwo);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramef.jdField_a_of_type_Anwo = anxo.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramef.jdField_a_of_type_Anwo = anxo.a(((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
    }
  }
  
  private void a(ef paramef, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837971), paramInt1, paramInt2, false);
        Object localObject1 = bdhj.a(localBitmap, aepi.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
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
          paramef.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
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
    paramef.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private boolean a(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {}
    do
    {
      return true;
      if (paramef.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
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
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramef.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramef.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramef.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText(arrr.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131694091)))) {
        break label540;
      }
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramef.a().jdField_c_of_type_AndroidWidgetTextView.setText(ey.a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramef.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramef.a().e.setVisibility(0);
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131694057);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843830);
      break;
      label492:
      paramef.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843830);
      break label128;
      label508:
      paramef.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843830);
      break label173;
      label524:
      paramef.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843830);
      break label218;
      label540:
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693995);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label578:
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692565);
      } else if (i == j) {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + j);
      } else {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      }
    }
    label709:
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = arzx.a(paramDataLineMsgRecord.trans2Entity());
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
  
  private boolean b(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {
      return true;
    }
    if (paramef.a().jdField_a_of_type_AndroidWidgetTextView == null) {
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
    dy localdy;
    label149:
    label314:
    if (j == i)
    {
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + i);
      j = ((Integer)paramef.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localdy = (dy)paramef.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localdy != null) {
        break label448;
      }
      localdy = new dy(this, paramef, paramDataLineMsgSet, j, null);
      paramef.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localdy);
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label502;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label468;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131694057);
      label228:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramef.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label535;
          }
          paramef.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramef.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramef.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label550;
          }
          paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramDataLineMsgSet = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131694040), new Object[] { Integer.valueOf(i) });
        paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramDataLineMsgSet);
      }
      return true;
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText(j + "/" + i);
      break;
      label448:
      localdy.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localdy.jdField_a_of_type_Ef = paramef;
      localdy.a();
      break label149;
      label468:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label228;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131692565);
      break label228;
      label502:
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label228;
      label535:
      paramef.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label314;
      label550:
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    } while (localDataLineMsgRecord == null);
    paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramef.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    label316:
    if ((localDataLineMsgRecord.path != null) && (new VFSFile(localDataLineMsgRecord.path).exists()))
    {
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
      label124:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label482;
      }
      paramef.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label467;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131694010);
      label230:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramef.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label540;
          }
          paramef.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramef.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramef.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label555;
          }
          paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alud.a(2131703143));
      }
      if (paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        break;
      }
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(alud.a(2131703135));
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label124;
      }
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label124;
      label467:
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label230;
      label482:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramef.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramef.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label230;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label230;
      label540:
      paramef.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label316;
      label555:
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramef.jdField_a_of_type_AndroidWidgetImageView.setTag(paramef);
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramef.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramef.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramef.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramef.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getTime();
  }
  
  protected View a(int paramInt, ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  protected void a(int paramInt, ef paramef, DataLineMsgSet paramDataLineMsgSet) {}
  
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
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131367936);
            }
          } while (paramListView == null);
          paramListView.setProgress((int)(f * 100.0F));
          return;
          localObject = (TextView)paramListView.findViewById(2131366344);
          paramListView = (ProgressBar)paramListView.findViewById(2131366314);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131367936);
      } while (paramListView == null);
      paramListView.setProgress((int)(f * 100.0F));
      return;
      paramListView = (ef)paramListView.getTag();
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
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat) {}
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
  }
  
  protected void a(ef paramef, View paramView, DataLineMsgRecord paramDataLineMsgRecord, anwo paramanwo)
  {
    if (paramanwo == null) {
      return;
    }
    if ((paramanwo.jdField_a_of_type_Int == 0) || (!paramanwo.a()))
    {
      paramanwo = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramanwo.getColorStateList(2131166925);
        paramef.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramanwo.getColorStateList(2131166924);; paramView = paramanwo.getColorStateList(2131166923))
      {
        paramef.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramanwo.getColorStateList(2131166921);
        break;
      }
    }
    if (paramanwo.jdField_b_of_type_Int == 0) {
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramanwo.c == 0)
    {
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166923));
      return;
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
    }
    paramef.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramanwo.c);
  }
  
  protected void a(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    arrr.a(paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText(arrr.d(paramDataLineMsgSet.filename));
    paramef.a().jdField_c_of_type_AndroidWidgetTextView.setText(ey.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131694057);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692564);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692562);
        } else {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692563);
        }
      }
      else
      {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131694057);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692565);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692556);
        } else if (!paramDataLineMsgSet.issuc) {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692562);
        } else {
          paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        }
      }
    }
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
    localObject = (ef)localView.getTag();
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
          d((ef)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((ef)localObject, paramListView));
        return false;
      } while (a((ef)localObject, paramListView));
      return false;
    } while (b((ef)localObject, paramListView));
    return false;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
  }
  
  protected void b(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {}
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
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText(arrr.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131694091)))) {
        break label333;
      }
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label127:
      paramef.a().jdField_c_of_type_AndroidWidgetTextView.setText(ey.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label371;
      }
      paramef.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramef.a().e.setVisibility(0);
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label200:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label386;
      }
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label245:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label401;
      }
      paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131694057);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label514;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843830);
      break;
      label333:
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramef.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693995);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label127;
      label371:
      paramef.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label200;
      label386:
      paramef.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label245;
      label401:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692565);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692556);
      } else if (!paramDataLineMsgSet.issuc) {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692562);
      } else {
        paramef.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
      }
    }
    label514:
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
    if (b())
    {
      if (paramView == null)
      {
        paramViewGroup = new ef();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558998, null);
        localObject1 = (TextView)paramView.findViewById(2131369585);
        localObject2 = (ImageView)paramView.findViewById(2131369584);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject1).setText(2131691436);
          ((ImageView)localObject2).setImageResource(2130839370);
        }
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramView.setVisibility(4);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
        localObject1 = paramView;
        return localObject1;
        paramViewGroup = (ef)paramView.getTag();
      }
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
    if (localObject2 == null) {
      return null;
    }
    paramInt = getItemViewType(paramInt);
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject2).getFirstItem();
    if (paramView == null)
    {
      localObject1 = new ef();
      if (a(paramInt))
      {
        paramView = a(paramInt, (ef)localObject1, (DataLineMsgSet)localObject2);
        label184:
        paramView.setTag(localObject1);
      }
    }
    Object localObject3;
    int i;
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = (ef)paramView.getTag())
    {
      paramViewGroup.a((DataLineMsgSet)localObject2);
      localObject1 = paramView;
      if (paramInt == 12) {
        break;
      }
      if (paramInt != 14) {
        break label3079;
      }
      localObject1 = paramView;
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break;
      }
      localObject2 = (apko)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361805);
      localObject1 = paramView;
      if (localObject2 == null) {
        break;
      }
      paramInt = aeqq.a(((apko)localObject2).getBitmap());
      paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(paramInt));
      return paramView;
      if (paramInt == 12)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558986, null);
        ((ef)localObject1).b((TextView)paramViewGroup.findViewById(2131365007));
        paramView = paramViewGroup;
        if (((ef)localObject1).b() == null) {
          break label184;
        }
        ((ef)localObject1).b().setText(2131694048);
        paramView = paramViewGroup;
        break label184;
      }
      Object localObject4;
      if (paramInt == 14)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558973, null);
        paramViewGroup = ((ef)localObject1).a();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367292));
        localObject3 = alud.a(2131703154);
        localObject4 = alud.a(2131703131);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject4 = new SpannableString("还想把文件发到好友手机？快来用\n" + (String)localObject3 + (String)localObject4);
        ((SpannableString)localObject4).setSpan(new dv(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + ((String)localObject3).length(), 33);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label184;
      }
      if (paramInt == 15)
      {
        paramViewGroup = ((ef)localObject1).a();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560706, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367292));
        break label184;
      }
      if (paramInt == 16)
      {
        paramViewGroup = ((ef)localObject1).a();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558817, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367292));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.getResources().getColorStateList(2131165394));
        break label184;
      }
      if (!((DataLineMsgSet)localObject2).isSendFromLocal())
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558987, null);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131367819);
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843834);
        i = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject2);
        if (i == 0)
        {
          paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843834);
          label691:
          ((ImageView)localObject3).setImageDrawable(paramView);
          paramView = paramViewGroup;
          label699:
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370802));
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        ((ef)localObject1).a((ImageView)paramView.findViewById(2131365809));
        ((ef)localObject1).a((TextView)paramView.findViewById(2131365008));
        break;
        if (i != 1) {
          break label691;
        }
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843832);
        break label691;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558993, null);
        break label699;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558994, null);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377606));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(bamp.a);
        if (((DataLineMsgSet)localObject2).isSendFromLocal()) {}
        for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166925);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166921))
        {
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup);
          ((ef)localObject1).a((ProgressBar)paramView.findViewById(2131376435));
          if (((ef)localObject1).a() == null) {
            break;
          }
          ((ef)localObject1).a().setVisibility(8);
          break;
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558974, null);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367921));
        ((ef)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131367936));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131375382));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377010));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364318));
        ((ef)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379174));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ef)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379173));
          ((ef)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367856));
          ((ef)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376897));
        }
        if (((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ef)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
          a((ef)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          label1449:
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
          if (BaseBubbleBuilder.jdField_a_of_type_Boolean) {
            break label1574;
          }
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
        }
        for (;;)
        {
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alud.a(2131703141));
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(alud.a(2131703149));
          break;
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ef)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
          break label1449;
          label1574:
          paramViewGroup = new afhj(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
          ((ef)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(paramViewGroup);
          i = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
          ((ef)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, i, -1);
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558976, null);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371975));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131371946));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366314));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377010));
        ((ef)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379174));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ef)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379173));
          ((ef)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367856));
          ((ef)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376897));
        }
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        a(((ef)localObject1).a().jdField_a_of_type_AndroidWidgetGridView);
        continue;
        localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558969, null);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3);
        if (alsf.a() > 17.0F)
        {
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          i = aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramViewGroup = (RelativeLayout)paramView.findViewById(2131366326);
          localObject4 = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject4).addRule(10, 2131366329);
          ((RelativeLayout)localObject3).updateViewLayout(paramViewGroup, (ViewGroup.LayoutParams)localObject4);
          localObject3 = (AsyncImageView)paramView.findViewById(2131366302);
          ((AsyncImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject4 = new RelativeLayout.LayoutParams(i, i);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9, 2131366326);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 2131366326);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131366339);
          ((TextView)localObject3).setGravity(16);
          localObject4 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366302);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131366326);
          ((RelativeLayout.LayoutParams)localObject4).addRule(10, 2131366326);
          ((RelativeLayout.LayoutParams)localObject4).setMargins(aepi.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131366344);
          ((TextView)localObject3).setGravity(5);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131366326);
          ((RelativeLayout.LayoutParams)localObject4).addRule(12, 2131366326);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ef)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131366343);
          ((TextView)localObject3).setGravity(17);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131366326);
          ((RelativeLayout.LayoutParams)localObject4).addRule(2, 2131366344);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ef)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject3);
        }
        for (;;)
        {
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366314));
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130850137);
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          break;
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366302));
          ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366339));
          ((ef)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366343));
          ((ef)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366344));
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558967, null);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366302));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366339));
        ((ef)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366317));
        ((ef)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366343));
        ((ef)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366344));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366314));
        ((ef)localObject1).a().e = ((TextView)paramView.findViewById(2131379173));
        ((ef)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367856));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376897));
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843829);
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558975, null);
        ((ef)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366303));
        ((ef)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366304));
        ((ef)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366305));
        ((ef)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366306));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366339));
        ((ef)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366317));
        ((ef)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366343));
        ((ef)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366344));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366314));
        ((ef)localObject1).a().e = ((TextView)paramView.findViewById(2131379173));
        ((ef)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367856));
        ((ef)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376897));
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843830);
        ((ef)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843830);
        ((ef)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843830);
        ((ef)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843830);
        ((ef)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ef)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ef)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ef)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      }
    }
    label3079:
    if (paramInt == 15)
    {
      paramViewGroup = paramViewGroup.a();
      localObject1 = arrr.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new dw(this, localDataLineMsgRecord));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
      return paramView;
    }
    if (paramInt == 16)
    {
      localObject1 = paramViewGroup.a();
      if ((localDataLineMsgRecord != null) && (!TextUtils.isEmpty(localDataLineMsgRecord.msg)) && (((em)localObject1).jdField_a_of_type_AndroidWidgetTextView != null) && (localDataLineMsgRecord.msg.indexOf(alud.a(2131703144)) >= 0))
      {
        paramViewGroup = arrr.a(localDataLineMsgRecord.msg, alud.a(2131703132), new dx(this, localDataLineMsgRecord));
        ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((em)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
        return paramView;
      }
    }
    switch (paramInt)
    {
    }
    while (a(paramInt))
    {
      a(paramInt, paramViewGroup, (DataLineMsgSet)localObject2);
      return paramView;
      paramViewGroup.a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
      paramViewGroup.a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
      localObject1 = paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView;
      localObject3 = alof.z;
      localObject3 = new bamp(localDataLineMsgRecord.msg, 13, 32, 6000);
      ((bamp)localObject3).a("biz_src_jc_aio");
      ((TextView)localObject1).setText((CharSequence)localObject3);
      ((TextView)localObject1).setVisibility(0);
      if (paramViewGroup.a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label3475;
        }
        paramViewGroup.a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject1).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
        break;
        label3475:
        paramViewGroup.a().setVisibility(8);
      }
      c(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      b(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      a(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      b(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      a(paramViewGroup, (DataLineMsgSet)localObject2);
    }
    a(localDataLineMsgRecord, paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup);
    int j;
    int k;
    if (ThemeUtil.isDefaultTheme())
    {
      paramInt = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      i = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight();
      j = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
      k = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom();
      if (!((DataLineMsgSet)localObject2).isSendFromLocal()) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), j, i, k);
      }
    }
    else
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject1 = (apko)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361805);
        if (localObject1 != null)
        {
          paramInt = aeqq.a(((apko)localObject1).getBitmap());
          paramViewGroup.a().setTextColor(ColorStateList.valueOf(paramInt));
        }
      }
      if (!a(((DataLineMsgSet)localObject2).getMsgId())) {
        break label3762;
      }
      localObject1 = bdns.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject2).getTime() * 1000L);
      paramViewGroup.a().setVisibility(0);
      paramViewGroup.a().setText((CharSequence)localObject1);
    }
    for (;;)
    {
      d(paramViewGroup, (DataLineMsgSet)localObject2);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt, j, i + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), k);
      break;
      label3762:
      paramViewGroup.a().setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dt
 * JD-Core Version:    0.7.0.1
 */