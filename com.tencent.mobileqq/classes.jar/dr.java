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
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import java.io.File;

public class dr
  extends et
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
  
  public dr(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ds(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165620);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165619);
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
        localDrawable = paramDataLineMsgRecord.getDrawable(2130848708);
        paramDataLineMsgRecord = paramDataLineMsgRecord.getDrawable(2130848515);
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
    int i = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - aciy.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
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
    paramDataLineMsgRecord = apir.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10006);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ed paramed)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = kre.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((kqz)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramed.jdField_a_of_type_Almt = alnt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramed.jdField_a_of_type_Almt != null)
        {
          paramed.jdField_a_of_type_Almt.a(paramRelativeLayout, null);
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
        ajrm.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramed.jdField_a_of_type_Almt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, fv.a(paramDataLineMsgRecord), i);
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
        a(paramed, paramRelativeLayout, paramDataLineMsgRecord, paramed.jdField_a_of_type_Almt);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramed.jdField_a_of_type_Almt = alnt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramed.jdField_a_of_type_Almt = alnt.a(((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
    }
  }
  
  private void a(ed paramed, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837905), paramInt1, paramInt2, false);
        Object localObject1 = bacm.a(localBitmap, aciy.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
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
          paramed.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
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
    paramed.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private boolean a(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {}
    do
    {
      return true;
      if (paramed.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
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
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramed.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramed.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramed.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText(apck.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131628331)))) {
        break label540;
      }
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramed.a().jdField_c_of_type_AndroidWidgetTextView.setText(ew.a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramed.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramed.a().e.setVisibility(0);
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131628297);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843322);
      break;
      label492:
      paramed.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843322);
      break label128;
      label508:
      paramed.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843322);
      break label173;
      label524:
      paramed.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843322);
      break label218;
      label540:
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131628235);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label578:
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626874);
      } else if (i == j) {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + j);
      } else {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      }
    }
    label709:
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = apir.a(paramDataLineMsgRecord.trans2Entity());
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
  
  private boolean b(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {
      return true;
    }
    if (paramed.a().jdField_a_of_type_AndroidWidgetTextView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    dw localdw;
    label148:
    label313:
    if (i == j)
    {
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + j);
      i = ((Integer)paramed.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localdw = (dw)paramed.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localdw != null) {
        break label401;
      }
      localdw = new dw(this, paramed, paramDataLineMsgSet, i, null);
      paramed.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localdw);
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label455;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label421;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131628297);
      label227:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramed.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label488;
          }
          paramed.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramed.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramed.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label503;
          }
          paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      return true;
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      break;
      label401:
      localdw.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localdw.jdField_a_of_type_Ed = paramed;
      localdw.a();
      break label148;
      label421:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label227;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131626874);
      break label227;
      label455:
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label227;
      label488:
      paramed.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label313;
      label503:
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    } while (localDataLineMsgRecord == null);
    paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramed.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    label316:
    if ((localDataLineMsgRecord.path != null) && (new File(localDataLineMsgRecord.path).exists()))
    {
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
      label124:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label482;
      }
      paramed.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label467;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131628250);
      label230:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramed.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label540;
          }
          paramed.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramed.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramed.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label555;
          }
          paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131636964));
      }
      if (paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        break;
      }
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(ajjy.a(2131636956));
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label124;
      }
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label124;
      label467:
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label230;
      label482:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramed.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramed.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label230;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label230;
      label540:
      paramed.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label316;
      label555:
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramed.jdField_a_of_type_AndroidWidgetImageView.setTag(paramed);
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramed.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramed.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramed.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramed.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getTime();
  }
  
  protected View a(int paramInt, ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  protected void a(int paramInt, ed paramed, DataLineMsgSet paramDataLineMsgSet) {}
  
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
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131302173);
            }
          } while (paramListView == null);
          paramListView.setProgress((int)(f * 100.0F));
          return;
          localObject = (TextView)paramListView.findViewById(2131300652);
          paramListView = (ProgressBar)paramListView.findViewById(2131300622);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131302173);
      } while (paramListView == null);
      paramListView.setProgress((int)(f * 100.0F));
      return;
      paramListView = (ed)paramListView.getTag();
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
  
  protected void a(ed paramed, View paramView, DataLineMsgRecord paramDataLineMsgRecord, almt paramalmt)
  {
    if (paramalmt == null) {
      return;
    }
    if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()))
    {
      paramalmt = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramalmt.getColorStateList(2131101282);
        paramed.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramalmt.getColorStateList(2131101281);; paramView = paramalmt.getColorStateList(2131101280))
      {
        paramed.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramalmt.getColorStateList(2131101278);
        break;
      }
    }
    if (paramalmt.jdField_b_of_type_Int == 0) {
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramalmt.c == 0)
    {
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131101280));
      return;
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
    }
    paramed.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramalmt.c);
  }
  
  protected void a(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    apck.a(paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText(apck.d(paramDataLineMsgSet.filename));
    paramed.a().jdField_c_of_type_AndroidWidgetTextView.setText(ew.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131628297);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626873);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626871);
        } else {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626872);
        }
      }
      else
      {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131628297);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626874);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626865);
        } else if (!paramDataLineMsgSet.issuc) {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626871);
        } else {
          paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        }
      }
    }
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
    localObject = (ed)localView.getTag();
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
          d((ed)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((ed)localObject, paramListView));
        return false;
      } while (a((ed)localObject, paramListView));
      return false;
    } while (b((ed)localObject, paramListView));
    return false;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
  }
  
  protected void b(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {}
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
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText(apck.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131628331)))) {
        break label333;
      }
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label127:
      paramed.a().jdField_c_of_type_AndroidWidgetTextView.setText(ew.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label371;
      }
      paramed.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramed.a().e.setVisibility(0);
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label200:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label386;
      }
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label245:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label401;
      }
      paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131628297);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label514;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843322);
      break;
      label333:
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramed.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131628235);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label127;
      label371:
      paramed.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label200;
      label386:
      paramed.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label245;
      label401:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626874);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626865);
      } else if (!paramDataLineMsgSet.issuc) {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131626871);
      } else {
        paramed.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
      }
    }
    label514:
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
        paramViewGroup = new ed();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493401, null);
        localObject1 = (TextView)paramView.findViewById(2131303660);
        localObject2 = (ImageView)paramView.findViewById(2131303659);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject1).setText(2131625806);
          ((ImageView)localObject2).setImageResource(2130839256);
        }
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramView.setVisibility(4);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.t();
        localObject1 = paramView;
        return localObject1;
        paramViewGroup = (ed)paramView.getTag();
      }
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.t();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
    if (localObject2 == null) {
      return null;
    }
    paramInt = getItemViewType(paramInt);
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject2).getFirstItem();
    if (paramView == null)
    {
      localObject1 = new ed();
      if (a(paramInt))
      {
        paramView = a(paramInt, (ed)localObject1, (DataLineMsgSet)localObject2);
        label184:
        paramView.setTag(localObject1);
      }
    }
    Object localObject3;
    int i;
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = (ed)paramView.getTag())
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
      localObject2 = (amyl)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131296269);
      localObject1 = paramView;
      if (localObject2 == null) {
        break;
      }
      paramInt = ackc.a(((amyl)localObject2).getBitmap());
      paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(paramInt));
      return paramView;
      if (paramInt == 12)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493389, null);
        ((ed)localObject1).b((TextView)paramViewGroup.findViewById(2131299355));
        paramView = paramViewGroup;
        if (((ed)localObject1).b() == null) {
          break label184;
        }
        ((ed)localObject1).b().setText(2131628288);
        paramView = paramViewGroup;
        break label184;
      }
      Object localObject4;
      if (paramInt == 14)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493376, null);
        paramViewGroup = ((ed)localObject1).a();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301543));
        localObject3 = ajjy.a(2131636975);
        localObject4 = ajjy.a(2131636952);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject4 = new SpannableString("还想把文件发到好友手机？快来用\n" + (String)localObject3 + (String)localObject4);
        ((SpannableString)localObject4).setSpan(new dt(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + ((String)localObject3).length(), 33);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label184;
      }
      if (paramInt == 15)
      {
        paramViewGroup = ((ed)localObject1).a();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494940, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301543));
        break label184;
      }
      if (paramInt == 16)
      {
        paramViewGroup = ((ed)localObject1).a();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493226, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301543));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.getResources().getColorStateList(2131099822));
        break label184;
      }
      if (!((DataLineMsgSet)localObject2).isSendFromLocal())
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493390, null);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131302061);
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843326);
        i = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject2);
        if (i == 0)
        {
          paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843326);
          label691:
          ((ImageView)localObject3).setImageDrawable(paramView);
          paramView = paramViewGroup;
          label699:
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131304813));
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        ((ed)localObject1).a((ImageView)paramView.findViewById(2131300127));
        ((ed)localObject1).a((TextView)paramView.findViewById(2131299356));
        break;
        if (i != 1) {
          break label691;
        }
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843324);
        break label691;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493396, null);
        break label699;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493397, null);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311220));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(axkd.a);
        if (((DataLineMsgSet)localObject2).isSendFromLocal()) {}
        for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101282);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101278))
        {
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup);
          ((ed)localObject1).a((ProgressBar)paramView.findViewById(2131310116));
          if (((ed)localObject1).a() == null) {
            break;
          }
          ((ed)localObject1).a().setVisibility(8);
          break;
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493377, null);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131302158));
        ((ed)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131302173));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131309117));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310661));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298694));
        ((ed)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312675));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ed)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312674));
          ((ed)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302094));
          ((ed)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310545));
        }
        if (((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ed)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
          a((ed)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          label1449:
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
          if (BaseBubbleBuilder.jdField_a_of_type_Boolean) {
            break label1574;
          }
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
        }
        for (;;)
        {
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131636962));
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(ajjy.a(2131636970));
          break;
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ed)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
          break label1449;
          label1574:
          paramViewGroup = new aczk(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
          ((ed)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(paramViewGroup);
          i = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
          ((ed)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, i, -1);
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493379, null);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305942));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131305913));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131300622));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310661));
        ((ed)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312675));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ed)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312674));
          ((ed)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302094));
          ((ed)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310545));
        }
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        a(((ed)localObject1).a().jdField_a_of_type_AndroidWidgetGridView);
        continue;
        localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493372, null);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3);
        if (ajia.a() > 17.0F)
        {
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          i = aciy.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramViewGroup = (RelativeLayout)paramView.findViewById(2131300634);
          localObject4 = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject4).addRule(10, 2131300637);
          ((RelativeLayout)localObject3).updateViewLayout(paramViewGroup, (ViewGroup.LayoutParams)localObject4);
          localObject3 = (AsyncImageView)paramView.findViewById(2131300610);
          ((AsyncImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject4 = new RelativeLayout.LayoutParams(i, i);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9, 2131300634);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 2131300634);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131300647);
          ((TextView)localObject3).setGravity(16);
          localObject4 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131300610);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131300634);
          ((RelativeLayout.LayoutParams)localObject4).addRule(10, 2131300634);
          ((RelativeLayout.LayoutParams)localObject4).setMargins(aciy.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131300652);
          ((TextView)localObject3).setGravity(5);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131300634);
          ((RelativeLayout.LayoutParams)localObject4).addRule(12, 2131300634);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ed)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131300651);
          ((TextView)localObject3).setGravity(17);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131300634);
          ((RelativeLayout.LayoutParams)localObject4).addRule(2, 2131300652);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((ed)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject3);
        }
        for (;;)
        {
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131300622));
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130849385);
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          break;
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300610));
          ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300647));
          ((ed)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300651));
          ((ed)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300652));
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493370, null);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300610));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300647));
        ((ed)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300625));
        ((ed)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300651));
        ((ed)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300652));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131300622));
        ((ed)localObject1).a().e = ((TextView)paramView.findViewById(2131312674));
        ((ed)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302094));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310545));
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843321);
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493378, null);
        ((ed)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300611));
        ((ed)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300612));
        ((ed)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300613));
        ((ed)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300614));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300647));
        ((ed)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300625));
        ((ed)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300651));
        ((ed)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300652));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131300622));
        ((ed)localObject1).a().e = ((TextView)paramView.findViewById(2131312674));
        ((ed)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302094));
        ((ed)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131310545));
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843322);
        ((ed)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843322);
        ((ed)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843322);
        ((ed)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843322);
        ((ed)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ed)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ed)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ed)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      }
    }
    label3079:
    if (paramInt == 15)
    {
      paramViewGroup = paramViewGroup.a();
      localObject1 = apck.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new du(this, localDataLineMsgRecord));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
      return paramView;
    }
    if (paramInt == 16)
    {
      localObject1 = paramViewGroup.a();
      if ((localDataLineMsgRecord != null) && (!TextUtils.isEmpty(localDataLineMsgRecord.msg)) && (((ek)localObject1).jdField_a_of_type_AndroidWidgetTextView != null) && (localDataLineMsgRecord.msg.indexOf(ajjy.a(2131636965)) >= 0))
      {
        paramViewGroup = apck.a(localDataLineMsgRecord.msg, ajjy.a(2131636953), new dv(this, localDataLineMsgRecord));
        ((ek)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        ((ek)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((ek)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
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
      localObject3 = ajed.z;
      localObject3 = new axkd(localDataLineMsgRecord.msg, 13, 32, 6000);
      ((axkd)localObject3).a("biz_src_jc_aio");
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
        localObject1 = (amyl)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131296269);
        if (localObject1 != null)
        {
          paramInt = ackc.a(((amyl)localObject1).getBitmap());
          paramViewGroup.a().setTextColor(ColorStateList.valueOf(paramInt));
        }
      }
      if (!a(((DataLineMsgSet)localObject2).getMsgId())) {
        break label3762;
      }
      localObject1 = baiu.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject2).getTime() * 1000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dr
 * JD-Core Version:    0.7.0.1
 */