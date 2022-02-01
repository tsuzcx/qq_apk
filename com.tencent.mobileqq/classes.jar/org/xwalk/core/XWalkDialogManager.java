package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.util.ArrayList;

public class XWalkDialogManager
{
  public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
  public static final int DIALOG_DECOMPRESSING = 11;
  public static final int DIALOG_DOWNLOADING = 12;
  public static final int DIALOG_DOWNLOAD_ERROR = 6;
  public static final int DIALOG_NEWER_VERSION = 3;
  public static final int DIALOG_NOT_FOUND = 1;
  public static final int DIALOG_OLDER_VERSION = 2;
  public static final int DIALOG_SELECT_STORE = 7;
  public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
  public static final int DIALOG_UNSUPPORTED_STORE = 8;
  private static final String TAG = "XWalkLib";
  private Dialog mActiveDialog;
  private AlertDialog mArchitectureMismatchDialog;
  private Context mContext;
  private ProgressDialog mDecompressingDialog;
  private AlertDialog mDownloadErrorDialog;
  private ProgressDialog mDownloadingDialog;
  private AlertDialog mNewerVersionDialog;
  private AlertDialog mNotFoundDialog;
  private AlertDialog mOlderVersionDialog;
  private AlertDialog mSelectStoreDialog;
  private AlertDialog mSignatureCheckErrorDialog;
  private AlertDialog mUnsupportedStoreDialog;
  
  public XWalkDialogManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private AlertDialog buildAlertDialog()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.mContext).create();
    localAlertDialog.setIcon(17301543);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setCanceledOnTouchOutside(false);
    return localAlertDialog;
  }
  
  private ProgressDialog buildProgressDialog()
  {
    ReportProgressDialog localReportProgressDialog = new ReportProgressDialog(this.mContext);
    localReportProgressDialog.setIndeterminate(true);
    localReportProgressDialog.setCancelable(false);
    localReportProgressDialog.setCanceledOnTouchOutside(false);
    return localReportProgressDialog;
  }
  
  private void setMessage(AlertDialog paramAlertDialog, int paramInt)
  {
    setMessage(paramAlertDialog, this.mContext.getString(paramInt));
  }
  
  private void setMessage(AlertDialog paramAlertDialog, String paramString)
  {
    String str = paramString.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
    paramString = str;
    if (str.startsWith("this")) {
      paramString = str.replaceFirst("this", "This");
    }
    paramAlertDialog.setMessage(paramString);
  }
  
  private void setNegativeButton(AlertDialog paramAlertDialog, int paramInt)
  {
    paramAlertDialog.setButton(-2, this.mContext.getString(paramInt), (DialogInterface.OnClickListener)null);
  }
  
  private void setPositiveButton(AlertDialog paramAlertDialog, int paramInt)
  {
    paramAlertDialog.setButton(-1, this.mContext.getString(paramInt), (DialogInterface.OnClickListener)null);
  }
  
  private void setTitle(AlertDialog paramAlertDialog, int paramInt)
  {
    paramAlertDialog.setTitle(this.mContext.getString(paramInt));
  }
  
  private void showDialog(AlertDialog paramAlertDialog, ArrayList<XWalkDialogManager.ButtonAction> paramArrayList)
  {
    paramAlertDialog.setOnShowListener(new XWalkDialogManager.1(this, paramArrayList, paramAlertDialog));
    this.mActiveDialog = paramAlertDialog;
    this.mActiveDialog.show();
  }
  
  void dismissDialog()
  {
    this.mActiveDialog.dismiss();
    this.mActiveDialog = null;
  }
  
  public AlertDialog getAlertDialog(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.mNotFoundDialog == null)
      {
        this.mNotFoundDialog = buildAlertDialog();
        setTitle(this.mNotFoundDialog, 2131916766);
        setMessage(this.mNotFoundDialog, 2131916765);
        setPositiveButton(this.mNotFoundDialog, 2131918192);
        setNegativeButton(this.mNotFoundDialog, 2131918190);
      }
      return this.mNotFoundDialog;
    }
    if (paramInt == 2)
    {
      if (this.mOlderVersionDialog == null)
      {
        this.mOlderVersionDialog = buildAlertDialog();
        setTitle(this.mOlderVersionDialog, 2131916768);
        setMessage(this.mOlderVersionDialog, 2131916767);
        setPositiveButton(this.mOlderVersionDialog, 2131918192);
        setNegativeButton(this.mOlderVersionDialog, 2131918190);
      }
      return this.mOlderVersionDialog;
    }
    if (paramInt == 3)
    {
      if (this.mNewerVersionDialog == null)
      {
        this.mNewerVersionDialog = buildAlertDialog();
        setTitle(this.mNewerVersionDialog, 2131916764);
        setMessage(this.mNewerVersionDialog, 2131916763);
        setNegativeButton(this.mNewerVersionDialog, 2131918190);
      }
      return this.mNewerVersionDialog;
    }
    if (paramInt == 4)
    {
      if (this.mArchitectureMismatchDialog == null)
      {
        this.mArchitectureMismatchDialog = buildAlertDialog();
        setTitle(this.mArchitectureMismatchDialog, 2131916762);
        setMessage(this.mArchitectureMismatchDialog, 2131916761);
        setPositiveButton(this.mArchitectureMismatchDialog, 2131918192);
        setNegativeButton(this.mArchitectureMismatchDialog, 2131918190);
      }
      return this.mArchitectureMismatchDialog;
    }
    if (paramInt == 5)
    {
      if (this.mSignatureCheckErrorDialog == null)
      {
        this.mSignatureCheckErrorDialog = buildAlertDialog();
        setTitle(this.mSignatureCheckErrorDialog, 2131916770);
        setMessage(this.mSignatureCheckErrorDialog, 2131916769);
        setNegativeButton(this.mSignatureCheckErrorDialog, 2131918190);
      }
      return this.mSignatureCheckErrorDialog;
    }
    if (paramInt == 6)
    {
      if (this.mDownloadErrorDialog == null)
      {
        this.mDownloadErrorDialog = buildAlertDialog();
        setTitle(this.mDownloadErrorDialog, 2131888261);
        setMessage(this.mDownloadErrorDialog, 2131888800);
        setPositiveButton(this.mDownloadErrorDialog, 2131918193);
        setNegativeButton(this.mDownloadErrorDialog, 2131918189);
      }
      return this.mDownloadErrorDialog;
    }
    if (paramInt == 7)
    {
      if (this.mSelectStoreDialog == null)
      {
        this.mSelectStoreDialog = buildAlertDialog();
        setTitle(this.mSelectStoreDialog, 2131888261);
        setPositiveButton(this.mSelectStoreDialog, 2131918191);
      }
      return this.mSelectStoreDialog;
    }
    if (paramInt == 8)
    {
      if (this.mUnsupportedStoreDialog == null)
      {
        this.mUnsupportedStoreDialog = buildAlertDialog();
        setTitle(this.mUnsupportedStoreDialog, 2131888261);
        setMessage(this.mUnsupportedStoreDialog, 2131917758);
        setNegativeButton(this.mUnsupportedStoreDialog, 2131918190);
      }
      return this.mUnsupportedStoreDialog;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid dialog id ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ProgressDialog getProgressDialog(int paramInt)
  {
    if (paramInt == 11)
    {
      if (this.mDecompressingDialog == null)
      {
        this.mDecompressingDialog = buildProgressDialog();
        setTitle(this.mDecompressingDialog, 2131888261);
        setMessage(this.mDecompressingDialog, 2131888410);
        setNegativeButton(this.mDecompressingDialog, 2131918189);
        this.mDecompressingDialog.setProgressStyle(0);
      }
      return this.mDecompressingDialog;
    }
    if (paramInt == 12)
    {
      if (this.mDownloadingDialog == null)
      {
        this.mDownloadingDialog = buildProgressDialog();
        setTitle(this.mDownloadingDialog, 2131888261);
        setMessage(this.mDownloadingDialog, 2131888803);
        setNegativeButton(this.mDownloadingDialog, 2131918189);
        this.mDownloadingDialog.setProgressStyle(1);
      }
      return this.mDownloadingDialog;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid dialog id ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean isShowingDialog()
  {
    Dialog localDialog = this.mActiveDialog;
    return (localDialog != null) && (localDialog.isShowing());
  }
  
  public void setAlertDialog(int paramInt, AlertDialog paramAlertDialog)
  {
    if ((!(paramAlertDialog instanceof ProgressDialog)) && (!(paramAlertDialog instanceof DatePickerDialog)) && (!(paramAlertDialog instanceof TimePickerDialog)))
    {
      if (paramInt == 1)
      {
        this.mNotFoundDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 2)
      {
        this.mOlderVersionDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 3)
      {
        this.mNewerVersionDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 4)
      {
        this.mArchitectureMismatchDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 5)
      {
        this.mSignatureCheckErrorDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 6)
      {
        this.mDownloadErrorDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 7)
      {
        this.mSelectStoreDialog = paramAlertDialog;
        return;
      }
      if (paramInt == 8)
      {
        this.mUnsupportedStoreDialog = paramAlertDialog;
        return;
      }
      paramAlertDialog = new StringBuilder();
      paramAlertDialog.append("Invalid dialog id ");
      paramAlertDialog.append(paramInt);
      throw new IllegalArgumentException(paramAlertDialog.toString());
    }
    throw new IllegalArgumentException("The type of dialog must be AlertDialog");
  }
  
  void setProgress(int paramInt1, int paramInt2)
  {
    ProgressDialog localProgressDialog = (ProgressDialog)this.mActiveDialog;
    localProgressDialog.setIndeterminate(false);
    localProgressDialog.setMax(paramInt2);
    localProgressDialog.setProgress(paramInt1);
  }
  
  public void setProgressDialog(int paramInt, ProgressDialog paramProgressDialog)
  {
    if (paramInt == 11)
    {
      this.mDecompressingDialog = paramProgressDialog;
      return;
    }
    if (paramInt == 12)
    {
      this.mDownloadingDialog = paramProgressDialog;
      return;
    }
    paramProgressDialog = new StringBuilder();
    paramProgressDialog.append("Invalid dialog id ");
    paramProgressDialog.append(paramInt);
    throw new IllegalArgumentException(paramProgressDialog.toString());
  }
  
  void showDecompressProgress(Runnable paramRunnable)
  {
    ProgressDialog localProgressDialog = getProgressDialog(11);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
  }
  
  void showDownloadError(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AlertDialog localAlertDialog = getAlertDialog(6);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
    showDialog(localAlertDialog, localArrayList);
  }
  
  void showDownloadProgress(Runnable paramRunnable)
  {
    ProgressDialog localProgressDialog = getProgressDialog(12);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
  }
  
  void showInitializationError(int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    ArrayList localArrayList = new ArrayList();
    AlertDialog localAlertDialog;
    if (paramInt == 2)
    {
      localAlertDialog = getAlertDialog(1);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
      paramRunnable1 = localAlertDialog;
    }
    else if (paramInt == 3)
    {
      localAlertDialog = getAlertDialog(2);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
      paramRunnable1 = localAlertDialog;
    }
    else if (paramInt == 4)
    {
      paramRunnable2 = getAlertDialog(3);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, true));
      paramRunnable1 = paramRunnable2;
    }
    else if (paramInt == 6)
    {
      localAlertDialog = getAlertDialog(4);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
      paramRunnable1 = localAlertDialog;
    }
    else
    {
      if (paramInt != 7) {
        break label235;
      }
      paramRunnable2 = getAlertDialog(5);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, true));
      paramRunnable1 = paramRunnable2;
    }
    showDialog(paramRunnable1, localArrayList);
    return;
    label235:
    paramRunnable1 = new StringBuilder();
    paramRunnable1.append("Invalid status ");
    paramRunnable1.append(paramInt);
    throw new IllegalArgumentException(paramRunnable1.toString());
  }
  
  void showSelectStore(Runnable paramRunnable, String paramString)
  {
    AlertDialog localAlertDialog = getAlertDialog(7);
    setMessage(localAlertDialog, this.mContext.getString(2131916233).replace("STORE_NAME", paramString));
    paramString = new ArrayList();
    paramString.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable, true));
    showDialog(localAlertDialog, paramString);
  }
  
  void showUnsupportedStore(Runnable paramRunnable)
  {
    AlertDialog localAlertDialog = getAlertDialog(8);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, true));
    showDialog(localAlertDialog, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager
 * JD-Core Version:    0.7.0.1
 */