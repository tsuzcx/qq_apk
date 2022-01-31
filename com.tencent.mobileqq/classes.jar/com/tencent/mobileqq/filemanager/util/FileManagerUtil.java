package com.tencent.mobileqq.filemanager.util;

import adpn;
import adpo;
import adpp;
import adpq;
import adpr;
import adps;
import adpt;
import adpu;
import adpv;
import adpx;
import adpy;
import adpz;
import adqa;
import adqb;
import adqc;
import adqd;
import adqe;
import adqf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.weiyun.ResponseHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class FileManagerUtil
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap jdField_b_of_type_JavaUtilHashMap;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 2130841697;
    case 2: 
      return 2130841698;
    case 0: 
      return 2130841666;
    case 1: 
      return 2130841668;
    case 3: 
      return 2130841634;
    case 4: 
      return 2130841708;
    case 6: 
      return 2130841707;
    case 5: 
      return 2130841628;
    case 7: 
      return 2130841679;
    case 8: 
      return 2130841647;
    case 9: 
      return 2130841677;
    case 10: 
      return 2130841691;
    }
    return 2130841685;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int k = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = k;
      if (paramFileManagerEntity.bSend)
      {
        j = k;
        if (8 != paramFileManagerEntity.nOpType)
        {
          j = k;
          if (5 != paramFileManagerEntity.nOpType)
          {
            j = k;
            if (1 != paramFileManagerEntity.nOpType) {
              j = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.getCloudType()) {
        break label135;
      }
      if ((j != 0) && ((j == 0) || (i == 0))) {
        break label133;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (paramFileManagerEntity.peerType == 6000)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label133:
    return 3;
    label135:
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (j != 0) && (i == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  public static int a(String paramString)
  {
    for (;;)
    {
      try
      {
        String str1 = FileUtil.a(paramString);
        if (str1 != null)
        {
          i = str1.length();
          if (i != 0) {}
        }
        else
        {
          i = -1;
          return i;
        }
        str1 = str1.toLowerCase();
        if (jdField_b_of_type_JavaUtilHashMap == null) {
          jdField_b_of_type_JavaUtilHashMap = new HashMap();
        }
        try
        {
          Object localObject = Class.forName("android.media.MediaFile").getDeclaredField("sFileTypeMap");
          ((Field)localObject).setAccessible(true);
          localObject = ((HashMap)((Field)localObject).get(null)).keySet().iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            str2 = "." + str2;
            jdField_b_of_type_JavaUtilHashMap.put(str2.toLowerCase(), Integer.valueOf(1));
            continue;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
          jdField_b_of_type_JavaUtilHashMap.remove(".flv");
          jdField_b_of_type_JavaUtilHashMap.remove(".m");
          jdField_b_of_type_JavaUtilHashMap.remove(".webp");
          jdField_b_of_type_JavaUtilHashMap.remove(".vcf");
          jdField_b_of_type_JavaUtilHashMap.put(".bmp", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".jpg", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".jpeg", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".png", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".gif", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".webp", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".psd", Integer.valueOf(12));
          jdField_b_of_type_JavaUtilHashMap.put(".swf", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mov", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mp4", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".3gp", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".avi", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".rmvb", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mpg", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".rm", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".asf", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mpeg", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mkv", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".wmv", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".flv", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".f4v", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".webm", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mod", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mpe", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".fla", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".m4r", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".m4u", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".m4v", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".vob", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".doc", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".docx", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".wps", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".zip", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".rar", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".7z", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".tar", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".iso", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put("gz", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".apk", Integer.valueOf(5));
          jdField_b_of_type_JavaUtilHashMap.put(".apk.rename", Integer.valueOf(5));
          jdField_b_of_type_JavaUtilHashMap.put(".xls", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".xlsx", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".et", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".ppt", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".pptx", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".pps", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".dps", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".keynotes", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".htm", Integer.valueOf(8));
          jdField_b_of_type_JavaUtilHashMap.put(".html", Integer.valueOf(8));
          jdField_b_of_type_JavaUtilHashMap.put(".php", Integer.valueOf(8));
          jdField_b_of_type_JavaUtilHashMap.put(".pdf", Integer.valueOf(9));
          jdField_b_of_type_JavaUtilHashMap.put(".txt", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".epub", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".rtf", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".c", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".conf", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".cpp", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".h", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".java", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".log", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".prop", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".rc", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".sh", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".xml", Integer.valueOf(10));
          if (jdField_b_of_type_JavaUtilHashMap.containsKey(str1.toLowerCase())) {
            i = ((Integer)jdField_b_of_type_JavaUtilHashMap.get(str1.toLowerCase())).intValue();
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
          continue;
        }
        catch (Exception localException)
        {
          if (jdField_b_of_type_JavaUtilHashMap == null)
          {
            i = 11;
            continue;
          }
          jdField_b_of_type_JavaUtilHashMap.put(".mp3", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".wav", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m4a", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".wave", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".midi", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".wma", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".ogg", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".ape", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".acc", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".aac", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".aiff", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".mid", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".xmf", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".rtttl", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".flac", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".amr", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".mp2", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m3u", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m4b", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m4p", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".mpga", Integer.valueOf(1));
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label1540;
        }
      }
      finally {}
      QLog.w("FileManagerUtil<FileAssistant>", 2, "Unknow file Type[" + paramString + "]");
      label1540:
      int i = 11;
    }
  }
  
  public static int a(List paramList, long paramLong)
  {
    int i = 0;
    int j = paramList.size() - 1;
    int k = i;
    if (i <= j)
    {
      k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        if (localFileInfo.b() >= paramLong) {
          break label103;
        }
        k -= 1;
        j = i;
        i = k;
      }
    }
    label103:
    return k;
  }
  
  public static long a()
  {
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    return (short)(int)((int)(i & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 10002: 
      return 127L;
    case 1029: 
      return 118L;
    case 1006: 
      return 102L;
    case 1010: 
      return 109L;
    }
    return 124L;
  }
  
  public static long a(long paramLong)
  {
    return 2863315899L << 31 | paramLong;
  }
  
  public static long a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static StateListDrawable a(Context paramContext, int paramInt)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    try
    {
      Object localObject = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      Bitmap localBitmap = Bitmap.createBitmap(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), Bitmap.Config.ARGB_8888);
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.set(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -67, 0.0F, 1.0F, 0.0F, 0.0F, -67, 0.0F, 0.0F, 1.0F, 0.0F, -67, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
      Paint localPaint = new Paint();
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      new Canvas(localBitmap).drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
      localObject = new BitmapDrawable(localBitmap);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
      localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      paramContext = paramContext.getResources().getDrawable(paramInt);
      localStateListDrawable.addState(new int[] { 16842910 }, paramContext);
      return localStateListDrawable;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 2, paramContext, new Object[] { "decodeResource caused this error, null will be returned" });
    }
    return null;
  }
  
  public static SpannableString a(String paramString1, String paramString2, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new adqe(paramTipsClickedInterface);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(2131492876), i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  public static FileManagerEntity a()
  {
    Object localObject3 = FMDataCache.c();
    Object localObject2 = FMDataCache.b();
    Object localObject1 = FMDataCache.e();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).a() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (a(((WeiYunFileInfo)localObject2).jdField_c_of_type_JavaLangString) == 0) {
          return a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(7);
    localFileManagerEntity.bSend = false;
    Object localObject;
    if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_a_of_type_Int)
    {
      localFileManagerEntity.status = -1;
      localFileManagerEntity.fileName = paramMpfileTaskInfo.jdField_d_of_type_JavaLangString;
      localFileManagerEntity.setFilePath(paramMpfileTaskInfo.jdField_e_of_type_JavaLangString);
      localFileManagerEntity.fileSize = paramMpfileTaskInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
      if (localFileManagerEntity.nFileType == 0)
      {
        localObject = (DataLineHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(8);
        if (((DataLineHandler)localObject).a().a() != null) {
          break label354;
        }
        if (QLog.isColorLevel()) {
          QLog.e("##########", 2, "插件的service没有启动");
        }
      }
    }
    for (;;)
    {
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = paramMpfileTaskInfo.jdField_d_of_type_Long;
      localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.jdField_c_of_type_JavaLangString;
      localFileManagerEntity.peerDin = paramLong;
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramMpfileTaskInfo.jdField_d_of_type_JavaLangString + "] by mpfile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)localObject).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_c_of_type_Int)
      {
        localFileManagerEntity.status = 1;
        localFileManagerEntity.fProgress = 1.0F;
        break;
      }
      if ((paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_d_of_type_Int) || (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_e_of_type_Int))
      {
        localFileManagerEntity.status = 3;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
        break;
      }
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      break;
      label354:
      localFileManagerEntity.strLargeThumPath = String.format("%s/%s", new Object[] { ((DataLineHandler)localObject).a().a(), paramMpfileTaskInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject = localFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = paramQQAppInterface.a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).a();
      localFileManagerEntity.status = b(paramMessageForFile.status);
      if (!paramMessageForFile.isSend()) {
        break label442;
      }
      localFileManagerEntity.setCloudType(3);
      if (!TextUtils.isEmpty(paramMessageForFile.url)) {
        break label430;
      }
      localFileManagerEntity.status = 16;
      if (localTransFileInfo != null)
      {
        if (localTransFileInfo.uuid == null) {
          break label492;
        }
        localObject = new String(localTransFileInfo.uuid);
        label277:
        localFileManagerEntity.Uuid = ((String)localObject);
      }
      localFileManagerEntity.fileName = paramMessageForFile.fileName;
      localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
      if (!paramMessageForFile.isSend()) {
        break label499;
      }
    }
    label430:
    label442:
    label492:
    label499:
    for (int i = 0;; i = 1)
    {
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.peerUin = paramMessageForFile.frienduin;
      localFileManagerEntity.peerType = paramMessageForFile.istroop;
      localFileManagerEntity.peerNick = a(paramQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
      localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
      localFileManagerEntity.fProgress = ((float)paramQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      paramQQAppInterface.a().d(localFileManagerEntity);
      localFileManagerEntity.bDelInFM = true;
      localObject = localFileManagerEntity;
      return localObject;
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localObject = "";
      break label277;
    }
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramDataLineMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity1 = new FileManagerEntity();
      localFileManagerEntity1.nSessionId = a().longValue();
      paramDataLineMsgRecord.entityID = localFileManagerEntity1.nSessionId;
      localFileManagerEntity1.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2 = localFileManagerEntity1;
      if (paramDataLineMsgRecord.nOpType == 31)
      {
        localFileManagerEntity1.strTroopFilePath = paramDataLineMsgRecord.fileUuid;
        localFileManagerEntity2 = localFileManagerEntity1;
      }
    }
    localFileManagerEntity2.setCloudType(6);
    localFileManagerEntity2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    if (paramDataLineMsgRecord.fileMsgStatus == 0L) {
      if (!paramDataLineMsgRecord.issuc)
      {
        localFileManagerEntity2.status = 0;
        if (paramDataLineMsgRecord.nOpType == 1) {
          localFileManagerEntity2.bSend = false;
        }
        localFileManagerEntity2.fileName = paramDataLineMsgRecord.filename;
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
          localFileManagerEntity2.setFilePath(paramDataLineMsgRecord.path);
        }
        localFileManagerEntity2.Uuid = paramDataLineMsgRecord.serverPath;
        if ((localFileManagerEntity2.Uuid == null) && ((paramDataLineMsgRecord.nOpType == 31) || (paramDataLineMsgRecord.nOpType == 29))) {
          localFileManagerEntity2.Uuid = paramDataLineMsgRecord.fileUuid;
        }
        if (1 != DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid)) {
          break label570;
        }
        localFileManagerEntity2.peerType = 6003;
        localFileManagerEntity2.peerUin = AppConstants.z;
        label234:
        localFileManagerEntity2.fileSize = paramDataLineMsgRecord.filesize;
        localFileManagerEntity2.strFileMd5 = com.tencent.mobileqq.utils.HexUtil.a(paramDataLineMsgRecord.md5);
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.filename);
        if (localFileManagerEntity2.nFileType != 0) {
          break label587;
        }
        localFileManagerEntity2.strThumbPath = paramDataLineMsgRecord.thumbPath;
        localFileManagerEntity2.strLargeThumPath = paramDataLineMsgRecord.thumbPath;
      }
    }
    for (;;)
    {
      if (paramDataLineMsgRecord.strMoloKey != null)
      {
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.path);
        localFileManagerEntity2.isFromrMolo = true;
      }
      localFileManagerEntity2.fProgress = paramDataLineMsgRecord.progress;
      if ((localFileManagerEntity2.fProgress == 1.0D) && ((localFileManagerEntity2.status == 3) || (localFileManagerEntity2.status == -1))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      if ((paramDataLineMsgRecord.nOpType == 1) && (Float.compare(paramDataLineMsgRecord.progress, 1.0F) == 0) && ((TextUtils.isEmpty(paramDataLineMsgRecord.path)) || (!new File(paramDataLineMsgRecord.path).exists()))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      localFileManagerEntity2.uniseq = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2.nOpType = paramDataLineMsgRecord.nOpType;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramDataLineMsgRecord.filename + "] by dataline size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        localFileManagerEntity2.status = 2;
        break;
      }
      localFileManagerEntity2.status = 1;
      break;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        if (paramDataLineMsgRecord.progress == 0.0F)
        {
          localFileManagerEntity2.status = 0;
          break;
        }
        localFileManagerEntity2.status = 3;
        break;
      }
      localFileManagerEntity2.status = -1;
      break;
      label570:
      localFileManagerEntity2.peerType = 6000;
      localFileManagerEntity2.peerUin = AppConstants.y;
      break label234;
      label587:
      if ((localFileManagerEntity2.nFileType == -1) && (paramDataLineMsgRecord.msgtype == -2000)) {
        localFileManagerEntity2.nFileType = 0;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramMessageForDeviceFile.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramMessageForDeviceFile.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceFile.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceFile.isSendFromLocal();
    localFileManagerEntity2.nOpType = 1;
    if (localFileManagerEntity2.bSend) {
      localFileManagerEntity2.nOpType = 0;
    }
    if ((paramMessageForDeviceFile.nFileStatus == 3) || (paramMessageForDeviceFile.nFileStatus == 1) || (paramMessageForDeviceFile.nFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = a(paramMessageForDeviceFile.filePath);
      if (!TextUtils.isEmpty(paramMessageForDeviceFile.filePath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceFile.filePath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceFile.fileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceFile.filePath);
      if ((localFileManagerEntity2.nFileType == -1) && (paramMessageForDeviceFile.strServiceName.equals(DeviceMsgHandle.jdField_d_of_type_JavaLangString))) {
        localFileManagerEntity2.nFileType = 0;
      }
      localFileManagerEntity2.fProgress = paramMessageForDeviceFile.progress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceFile.uSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceFile.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceFile.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceFile.uniseq;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramMessageForDeviceFile.srcFileName + "] by devices size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceFile.nFileStatus == 4) {
        localFileManagerEntity2.status = 3;
      } else if (paramMessageForDeviceFile.nFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceFile.nFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      } else if (paramMessageForDeviceFile.nFileStatus == -1) {
        localFileManagerEntity2.status = -1;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramMessageForDeviceSingleStruct.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramMessageForDeviceSingleStruct.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceSingleStruct.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceSingleStruct.isSendFromLocal();
    localFileManagerEntity2.nOpType = 0;
    if ((paramMessageForDeviceSingleStruct.nMediaFileStatus == 3) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 1) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.uniseq;
      localFileManagerEntity2.fileName = paramMessageForDeviceSingleStruct.strMediaFileName;
      localFileManagerEntity2.strThumbPath = paramMessageForDeviceSingleStruct.strCoverPath;
      localFileManagerEntity2.strLargeThumPath = paramMessageForDeviceSingleStruct.strCoverPath;
      if (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceSingleStruct.strMediaPath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceSingleStruct.nMediaFileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceSingleStruct.strMediaFileName);
      localFileManagerEntity2.fProgress = paramMessageForDeviceSingleStruct.nMediaProgress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.nMediaSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceSingleStruct.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceSingleStruct.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceSingleStruct.uniseq;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      }
    }
  }
  
  public static FileManagerEntity a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(6);
    localFileManagerEntity.bSend = paramPrinterItemMsgRecord.isSendFromLocal();
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    localFileManagerEntity.setFilePath(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.nOpType = 0;
    if (localFileManagerEntity.bSend) {
      localFileManagerEntity.nOpType = 0;
    }
    int i = paramPrinterItemMsgRecord.filename.lastIndexOf("/");
    if (i >= 0) {}
    for (localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename.substring(i + 1);; localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename)
    {
      File localFile = new File(localFileManagerEntity.getFilePath());
      if (localFile.exists()) {
        localFileManagerEntity.fileSize = localFile.length();
      }
      localFileManagerEntity.nFileType = a(paramPrinterItemMsgRecord.filename);
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.uniseq = paramPrinterItemMsgRecord.uSessionID;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramPrinterItemMsgRecord.filename + "] by print size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.d();
    localFileManagerEntity.setFilePath(paramFileInfo.c());
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.a() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = a(paramFileInfo.d()))
    {
      localFileManagerEntity.status = -1;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramFileInfo.d() + "]by local size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      localQQAppInterface.a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = a(paramOfflineFileInfo.jdField_b_of_type_JavaLangString);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.jdField_c_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.jdField_d_of_type_Long;
    localFileManagerEntity.bSend = paramOfflineFileInfo.jdField_a_of_type_Boolean;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramOfflineFileInfo.jdField_b_of_type_JavaLangString + "] by offlinefile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
    localQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity1 = new FileManagerEntity();
    localFileManagerEntity1.nSessionId = a().longValue();
    localFileManagerEntity1.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity1.fileName = paramWeiYunFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity1.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity1.nFileType = a(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString);
    localFileManagerEntity1.strThumbPath = paramWeiYunFileInfo.h;
    localFileManagerEntity1.setCloudType(2);
    localFileManagerEntity1.nWeiYunSrcType = paramWeiYunFileInfo.jdField_a_of_type_Int;
    if (localFileManagerEntity1.nWeiYunSrcType == 2) {
      localFileManagerEntity1.strLargeThumPath = paramWeiYunFileInfo.jdField_e_of_type_JavaLangString;
    }
    localFileManagerEntity1.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity1.bSend = false;
    localFileManagerEntity1.status = -1;
    localFileManagerEntity1.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity1.strFileMd5 = paramWeiYunFileInfo.i;
    localFileManagerEntity1.WeiYunDirKey = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity1.strFileSHA = paramWeiYunFileInfo.j;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity2 = localQQAppInterface.a().d(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (localFileManagerEntity2 != null)
    {
      localFileManagerEntity1.imgWidth = localFileManagerEntity2.imgWidth;
      localFileManagerEntity1.imgHeight = localFileManagerEntity2.imgHeight;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity1.nSessionId + "] fileName[" + paramWeiYunFileInfo.jdField_c_of_type_JavaLangString + "] by WeiYun size(" + localFileManagerEntity1.imgHeight + ":" + localFileManagerEntity1.imgWidth + ")");
    localQQAppInterface.a().d(localFileManagerEntity1);
    return localFileManagerEntity1;
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.g;
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localFileManagerEntity.fProgress = ((float)paramTroopFileStatusInfo.jdField_c_of_type_Long / (float)paramTroopFileStatusInfo.jdField_b_of_type_Long);
      localFileManagerEntity.nFileType = a(paramTroopFileStatusInfo.g);
      if ((6 <= paramTroopFileStatusInfo.jdField_b_of_type_Int) && (13 != paramTroopFileStatusInfo.jdField_b_of_type_Int)) {
        break label322;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localFileManagerEntity.strTroopFileSha1 = paramTroopFileStatusInfo.f;
      localFileManagerEntity.busId = paramTroopFileStatusInfo.jdField_e_of_type_Int;
      localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.jdField_a_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_a_of_type_Long);
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramTroopFileStatusInfo.g + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (!FileUtil.a(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
      break;
      label322:
      if (12 == paramTroopFileStatusInfo.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  /* Error */
  public static FileManagerUtil.VideoThumbInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1138	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)[B
    //   4: invokestatic 1143	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   7: astore_1
    //   8: new 154	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   15: invokestatic 1148	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/settings/FMSettings;
    //   18: invokevirtual 1149	com/tencent/mobileqq/filemanager/settings/FMSettings:d	()Ljava/lang/String;
    //   21: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 1151
    //   27: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_3
    //   38: new 1153	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo
    //   41: dup
    //   42: invokespecial 1154	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: iconst_0
    //   50: putfield 1155	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   53: aload 4
    //   55: aload_1
    //   56: putfield 1156	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload_3
    //   60: invokestatic 1158	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   63: ifeq +49 -> 112
    //   66: new 1160	android/graphics/BitmapFactory$Options
    //   69: dup
    //   70: invokespecial 1161	android/graphics/BitmapFactory$Options:<init>	()V
    //   73: astore_0
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 1164	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   79: aload_3
    //   80: aload_0
    //   81: invokestatic 1169	com/tencent/mobileqq/filemanager/util/FilePicURLDrawlableHelper:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   84: pop
    //   85: aload 4
    //   87: aload_0
    //   88: getfield 1172	android/graphics/BitmapFactory$Options:outWidth	I
    //   91: putfield 1173	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_b_of_type_Int	I
    //   94: aload 4
    //   96: aload_0
    //   97: getfield 1176	android/graphics/BitmapFactory$Options:outHeight	I
    //   100: putfield 1177	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_c_of_type_Int	I
    //   103: aload 4
    //   105: aload_3
    //   106: putfield 1178	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload 4
    //   111: areturn
    //   112: aload_0
    //   113: iconst_1
    //   114: invokestatic 1184	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnonnull +12 -> 133
    //   124: aload 4
    //   126: iconst_m1
    //   127: putfield 1155	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   130: aload 4
    //   132: areturn
    //   133: new 154	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   140: invokestatic 1148	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/settings/FMSettings;
    //   143: invokevirtual 1149	com/tencent/mobileqq/filemanager/settings/FMSettings:d	()Ljava/lang/String;
    //   146: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokestatic 1189	java/lang/System:currentTimeMillis	()J
    //   152: invokevirtual 683	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   155: ldc 192
    //   157: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 6
    //   165: new 154	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   172: invokestatic 1148	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/settings/FMSettings;
    //   175: invokevirtual 1149	com/tencent/mobileqq/filemanager/settings/FMSettings:d	()Ljava/lang/String;
    //   178: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 1191
    //   184: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 1195	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   193: new 436	java/io/File
    //   196: dup
    //   197: aload 6
    //   199: invokespecial 439	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore 7
    //   204: new 436	java/io/File
    //   207: dup
    //   208: aload 7
    //   210: invokevirtual 1198	java/io/File:getParent	()Ljava/lang/String;
    //   213: invokespecial 439	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 442	java/io/File:exists	()Z
    //   221: ifeq +10 -> 231
    //   224: aload_0
    //   225: invokevirtual 1201	java/io/File:isDirectory	()Z
    //   228: ifne +8 -> 236
    //   231: aload_0
    //   232: invokevirtual 1204	java/io/File:mkdirs	()Z
    //   235: pop
    //   236: aload 7
    //   238: invokevirtual 442	java/io/File:exists	()Z
    //   241: ifeq +11 -> 252
    //   244: aload 7
    //   246: invokevirtual 1207	java/io/File:isFile	()Z
    //   249: ifne +9 -> 258
    //   252: aload 7
    //   254: invokevirtual 1210	java/io/File:createNewFile	()Z
    //   257: pop
    //   258: new 1212	java/io/BufferedOutputStream
    //   261: dup
    //   262: new 1214	java/io/FileOutputStream
    //   265: dup
    //   266: aload 7
    //   268: invokespecial 1217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   271: invokespecial 1220	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   274: astore_1
    //   275: aload 5
    //   277: ifnull +88 -> 365
    //   280: aload_1
    //   281: astore_0
    //   282: aload 5
    //   284: getstatic 1226	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   287: bipush 60
    //   289: aload_1
    //   290: invokevirtual 1230	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   293: pop
    //   294: aload_1
    //   295: astore_0
    //   296: aload_1
    //   297: invokevirtual 1233	java/io/BufferedOutputStream:flush	()V
    //   300: aload_1
    //   301: ifnull +7 -> 308
    //   304: aload_1
    //   305: invokevirtual 1236	java/io/BufferedOutputStream:close	()V
    //   308: aload 7
    //   310: invokevirtual 442	java/io/File:exists	()Z
    //   313: ifeq +230 -> 543
    //   316: aload 6
    //   318: aload_3
    //   319: invokestatic 1239	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   322: pop
    //   323: aload 6
    //   325: invokestatic 1241	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   328: pop
    //   329: aload 5
    //   331: ifnull -222 -> 109
    //   334: aload 4
    //   336: aload 5
    //   338: invokevirtual 476	android/graphics/Bitmap:getWidth	()I
    //   341: putfield 1173	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_b_of_type_Int	I
    //   344: aload 4
    //   346: aload 5
    //   348: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   351: putfield 1177	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_c_of_type_Int	I
    //   354: aload 4
    //   356: areturn
    //   357: astore_0
    //   358: aload_0
    //   359: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   362: goto -104 -> 258
    //   365: aload_1
    //   366: astore_0
    //   367: aload 4
    //   369: iconst_m1
    //   370: putfield 1155	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   373: goto -73 -> 300
    //   376: astore_2
    //   377: aload_1
    //   378: astore_0
    //   379: aload 4
    //   381: bipush 254
    //   383: putfield 1155	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   386: aload_1
    //   387: astore_0
    //   388: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +46 -> 437
    //   394: aload_1
    //   395: astore_0
    //   396: ldc_w 378
    //   399: iconst_2
    //   400: new 154	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 1244
    //   410: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 6
    //   415: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 1246
    //   421: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_2
    //   425: invokevirtual 1249	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   428: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload_1
    //   438: ifnull -130 -> 308
    //   441: aload_1
    //   442: invokevirtual 1236	java/io/BufferedOutputStream:close	()V
    //   445: goto -137 -> 308
    //   448: astore_0
    //   449: goto -141 -> 308
    //   452: astore_2
    //   453: aconst_null
    //   454: astore_1
    //   455: aload_1
    //   456: astore_0
    //   457: aload 4
    //   459: bipush 254
    //   461: putfield 1155	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   464: aload_1
    //   465: astore_0
    //   466: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +46 -> 515
    //   472: aload_1
    //   473: astore_0
    //   474: ldc_w 378
    //   477: iconst_2
    //   478: new 154	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   485: ldc_w 1244
    //   488: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 6
    //   493: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 1251
    //   499: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_2
    //   503: invokevirtual 1252	java/io/IOException:getMessage	()Ljava/lang/String;
    //   506: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: aload_1
    //   516: ifnull -208 -> 308
    //   519: aload_1
    //   520: invokevirtual 1236	java/io/BufferedOutputStream:close	()V
    //   523: goto -215 -> 308
    //   526: astore_0
    //   527: goto -219 -> 308
    //   530: astore_1
    //   531: aconst_null
    //   532: astore_0
    //   533: aload_0
    //   534: ifnull +7 -> 541
    //   537: aload_0
    //   538: invokevirtual 1236	java/io/BufferedOutputStream:close	()V
    //   541: aload_1
    //   542: athrow
    //   543: aload 4
    //   545: iconst_m1
    //   546: putfield 1155	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   549: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq -443 -> 109
    //   555: ldc_w 378
    //   558: iconst_2
    //   559: ldc_w 1254
    //   562: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload 4
    //   567: areturn
    //   568: astore_0
    //   569: goto -261 -> 308
    //   572: astore_0
    //   573: goto -32 -> 541
    //   576: astore_1
    //   577: goto -44 -> 533
    //   580: astore_2
    //   581: goto -126 -> 455
    //   584: astore_2
    //   585: aconst_null
    //   586: astore_1
    //   587: goto -210 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	paramString	String
    //   7	513	1	localObject1	Object
    //   530	12	1	localObject2	Object
    //   576	1	1	localObject3	Object
    //   586	1	1	localObject4	Object
    //   376	49	2	localFileNotFoundException1	FileNotFoundException
    //   452	51	2	localIOException1	IOException
    //   580	1	2	localIOException2	IOException
    //   584	1	2	localFileNotFoundException2	FileNotFoundException
    //   37	282	3	str1	String
    //   45	521	4	localVideoThumbInfo	FileManagerUtil.VideoThumbInfo
    //   117	230	5	localBitmap	Bitmap
    //   163	329	6	str2	String
    //   202	107	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   252	258	357	java/io/IOException
    //   282	294	376	java/io/FileNotFoundException
    //   296	300	376	java/io/FileNotFoundException
    //   367	373	376	java/io/FileNotFoundException
    //   441	445	448	java/io/IOException
    //   258	275	452	java/io/IOException
    //   519	523	526	java/io/IOException
    //   258	275	530	finally
    //   304	308	568	java/io/IOException
    //   537	541	572	java/io/IOException
    //   282	294	576	finally
    //   296	300	576	finally
    //   367	373	576	finally
    //   379	386	576	finally
    //   388	394	576	finally
    //   396	437	576	finally
    //   457	464	576	finally
    //   466	472	576	finally
    //   474	515	576	finally
    //   282	294	580	java/io/IOException
    //   296	300	580	java/io/IOException
    //   367	373	580	java/io/IOException
    //   258	275	584	java/io/FileNotFoundException
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface)
  {
    return new adpr(paramQQAppInterface);
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new adpq(paramQQAppInterface, paramInt);
  }
  
  public static CharSequence a(FileManagerEntity paramFileManagerEntity)
  {
    return QfileTimeUtils.c(paramFileManagerEntity.srvTime) + "  " + b(paramFileManagerEntity);
  }
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 851
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: invokestatic 1296	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   12: invokestatic 1300	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokeinterface 1303 2 0
    //   20: checkcast 1305	[Ljava/lang/StackTraceElement;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: arraylength
    //   30: istore_1
    //   31: iconst_0
    //   32: istore_0
    //   33: iload_0
    //   34: iload_1
    //   35: if_icmpge +69 -> 104
    //   38: aload 4
    //   40: iload_0
    //   41: aaload
    //   42: astore 5
    //   44: aload_2
    //   45: astore_3
    //   46: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +17 -> 66
    //   52: aload_2
    //   53: astore_3
    //   54: ldc_w 1307
    //   57: iconst_1
    //   58: aload 5
    //   60: invokevirtual 1310	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   63: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_2
    //   67: astore_3
    //   68: new 154	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   75: aload_2
    //   76: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 5
    //   81: invokevirtual 1310	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   84: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 1312
    //   90: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_2
    //   97: iload_0
    //   98: iconst_1
    //   99: iadd
    //   100: istore_0
    //   101: goto -68 -> 33
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_2
    //   108: areturn
    //   109: astore_2
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    //   115: astore_2
    //   116: aload_3
    //   117: astore_2
    //   118: goto -14 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	69	0	i	int
    //   30	6	1	j	int
    //   6	102	2	str1	String
    //   109	5	2	localObject1	Object
    //   115	1	2	localException	Exception
    //   117	1	2	localObject2	Object
    //   8	109	3	str2	String
    //   23	16	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   42	38	5	localStackTraceElement	java.lang.StackTraceElement
    // Exception table:
    //   from	to	target	type
    //   9	25	109	finally
    //   27	31	109	finally
    //   46	52	109	finally
    //   54	66	109	finally
    //   68	97	109	finally
    //   9	25	115	java/lang/Exception
    //   27	31	115	java/lang/Exception
    //   46	52	115	java/lang/Exception
    //   54	66	115	java/lang/Exception
    //   68	97	115	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return "文件";
    case 1: 
      return "音乐";
    case 0: 
      return "图片";
    case 2: 
      return "视频";
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return "文档";
    }
    return "应用";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    long l2 = 604800000L;
    long l1 = l2;
    int i;
    int j;
    label136:
    label171:
    String str2;
    switch (paramInt)
    {
    default: 
      l1 = l2;
    case 0: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1 + paramLong);
      paramInt = localCalendar.get(1);
      i = localCalendar.get(2) + 1;
      j = localCalendar.get(5);
      str1 = paramInt + "-";
      if (i < 10)
      {
        str1 = str1 + "0" + i;
        if (j >= 10) {
          break label346;
        }
        str1 = str1 + "-0" + j;
        str2 = str1;
        if (paramBoolean)
        {
          paramInt = localCalendar.get(11);
          i = localCalendar.get(12);
          str1 = str1 + " ";
          if (paramInt >= 10) {
            break label377;
          }
        }
      }
      break;
    }
    label346:
    label377:
    for (String str1 = str1 + "0" + paramInt;; str1 = str1 + paramInt)
    {
      str1 = str1 + ":";
      if (i >= 10) {
        break label401;
      }
      str2 = str1 + "0" + i;
      return str2;
      l1 = 2592000000L;
      break;
      str1 = str1 + i;
      break label136;
      str1 = str1 + "-" + j;
      break label171;
    }
    label401:
    return str1 + i;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = a(paramQQAppInterface.getFilePath());
    }
    paramMessage = a(paramQQAppInterface.nFileType);
    return "[" + paramMessage + "]" + paramQQAppInterface.fileName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return null;
    }
    paramQQAppInterface = a(a(paramDataLineMsgRecord.path));
    return "[" + paramQQAppInterface + "]" + paramDataLineMsgRecord.filename;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (AppConstants.y.equalsIgnoreCase(paramString1)) {
      return "我的电脑";
    }
    if (AppConstants.z.equalsIgnoreCase(paramString1)) {
      return "我的iPad";
    }
    if (AppConstants.u.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return ContactUtils.b(paramQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity info, ");
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("], fileName[");
        localStringBuilder.append(paramFileManagerEntity.fileName);
        localStringBuilder.append("], cloudType[");
        localStringBuilder.append(paramFileManagerEntity.getCloudType());
        localStringBuilder.append("], uniseq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.uniseq));
        localStringBuilder.append("], nRelatedSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
        localStringBuilder.append("], bDelInAio[");
        localStringBuilder.append(paramFileManagerEntity.bDelInAio);
        localStringBuilder.append("], bDelInFM[");
        localStringBuilder.append(paramFileManagerEntity.bDelInFM);
        localStringBuilder.append("], fileSize[");
        localStringBuilder.append(paramFileManagerEntity.fileSize);
        localStringBuilder.append("], fProgress[");
        localStringBuilder.append(paramFileManagerEntity.fProgress);
        localStringBuilder.append("], lastTime[");
        localStringBuilder.append(paramFileManagerEntity.lastTime);
        localStringBuilder.append("], msgSeq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgSeq));
        localStringBuilder.append("], msgUid[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgUid));
        localStringBuilder.append("], msgTime[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgTime));
        localStringBuilder.append("], nFileType[");
        localStringBuilder.append(paramFileManagerEntity.nFileType);
        localStringBuilder.append("], nOpType[");
        localStringBuilder.append(paramFileManagerEntity.nOpType);
        localStringBuilder.append("], nWeiYunSrcType[");
        localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
        localStringBuilder.append("], peerNick[");
        localStringBuilder.append(paramFileManagerEntity.peerNick);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("], peerUin[");
        localStringBuilder.append(e(paramFileManagerEntity.peerUin));
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(e(paramFileManagerEntity.selfUin));
        localStringBuilder.append("], srvTime[");
        localStringBuilder.append(paramFileManagerEntity.srvTime);
        localStringBuilder.append("], status[");
        localStringBuilder.append(paramFileManagerEntity.status);
        localStringBuilder.append("], strFilePath[");
        localStringBuilder.append(paramFileManagerEntity.getFilePath());
        localStringBuilder.append("], strServerPath[");
        localStringBuilder.append(paramFileManagerEntity.strServerPath);
        localStringBuilder.append("], strThumbPath[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("], Uuid[");
        localStringBuilder.append(paramFileManagerEntity.Uuid);
        localStringBuilder.append("], WeiYunFileId[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], strFileMd5[");
        localStringBuilder.append(paramFileManagerEntity.strFileMd5);
        localStringBuilder.append("], strFileSHA[");
        localStringBuilder.append(paramFileManagerEntity.strFileSHA);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], WeiYunDirKey[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunDirKey);
        localStringBuilder.append("], _status[");
        localStringBuilder.append(paramFileManagerEntity.getStatus());
        localStringBuilder.append("], bOnceSuccess[");
        localStringBuilder.append(paramFileManagerEntity.bOnceSuccess);
        localStringBuilder.append("], imgHeight[");
        localStringBuilder.append(paramFileManagerEntity.imgHeight);
        localStringBuilder.append("], imgWidth[");
        localStringBuilder.append(paramFileManagerEntity.imgWidth);
        localStringBuilder.append("]");
        paramFileManagerEntity = localStringBuilder.toString();
      }
      finally {}
    }
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramByteStringMicro.length)
    {
      int j = paramByteStringMicro[i];
      localStringBuffer.append(arrayOfChar[(j >>> 4 & 0xF)]);
      localStringBuffer.append(arrayOfChar[(j & 0xF)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      a();
      localObject = "";
      return localObject;
    }
    int k = paramString.length();
    int i = paramString.lastIndexOf('/');
    int j = paramString.lastIndexOf('\\');
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "filepath without / ?");
        }
        i = 0;
      }
      String str2;
      String str1;
      for (;;)
      {
        str2 = paramString.substring(i, k);
        if ((QLog.isColorLevel()) && (str2 != null) && (str2.startsWith("."))) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
        }
        for (str1 = str2; (str1 != null) && (str1.startsWith(".")); str1 = str1.replaceFirst(".", "")) {}
        i += 1;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      localObject = "InvaildName";
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
      return "InvaildName";
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.getBytes().length < paramInt)) {
      return "";
    }
    int j = paramInt / 2;
    int i = paramInt / 4;
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramInt = 0;
    if (paramInt < arrayOfChar.length)
    {
      localStringBuilder1.append(arrayOfChar[paramInt]);
      if (localStringBuilder1.toString().getBytes().length <= j) {}
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      j = arrayOfChar.length;
      paramInt = arrayOfChar.length - 1;
      label94:
      if (paramInt <= 0) {
        break label168;
      }
      localStringBuilder2.append(arrayOfChar[paramInt]);
      if (localStringBuilder2.toString().getBytes().length <= i) {
        break label161;
      }
    }
    for (;;)
    {
      return localStringBuilder1.toString() + jdField_a_of_type_JavaLangString + paramString.substring(paramInt);
      paramInt += 1;
      break;
      label161:
      paramInt -= 1;
      break label94;
      label168:
      paramInt = j - 1;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int i;
    Object localObject2;
    do
    {
      return null;
      localObject1 = new File(FMSettings.a().d());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject1 = FMSettings.a().d() + a(paramString) + ".JPG";
      if (FileUtil.b((String)localObject1)) {
        return localObject1;
      }
      i = a(paramString);
      if (i != 0) {
        break label280;
      }
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread()) {
        break;
      }
      localObject2 = MediaStoreUtil.a(paramString, paramInt1, paramInt2);
    } while (localObject2 == null);
    for (;;)
    {
      try
      {
        FileUtil.a((Bitmap)localObject2, (String)localObject1);
        ((Bitmap)localObject2).recycle();
        MediaStoreUtil.a((String)localObject1, MediaStoreUtil.a(paramString));
        return localObject1;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramString.getMessage());
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramString.getMessage());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramString.getMessage());
        return null;
      }
      FileManagerUtil.FileExecutor.a().execute(new adqf((String)localObject1, paramString, paramInt1, paramInt2));
      continue;
      label280:
      if (i != 2) {
        break;
      }
      a(paramString, true, paramInt1, paramInt2, 3, new adpo((String)localObject1, paramString));
    }
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramTextPaint == null) || (paramInt1 <= 0))
    {
      localObject = "";
      return localObject;
    }
    int j;
    char[] arrayOfChar;
    int k;
    label54:
    int n;
    int m;
    if (paramInt2 > 1)
    {
      j = paramInt2;
      arrayOfChar = paramString.toCharArray();
      localObject = new StringBuilder();
      i = 0;
      k = 0;
      if (i >= arrayOfChar.length) {
        break label399;
      }
      ((StringBuilder)localObject).append(arrayOfChar[i]);
      n = i;
      m = k;
      if (paramTextPaint.measureText(((StringBuilder)localObject).toString()) <= paramInt1) {
        break label273;
      }
      n = i - 1;
      i = k + 1;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      m = i;
      if (i < j) {
        break label273;
      }
    }
    label393:
    label399:
    for (int i = 1;; i = 0)
    {
      localObject = paramString;
      if (i == 0) {
        break;
      }
      if (paramBoolean)
      {
        j = 6;
        label150:
        if (paramString.length() >= j) {
          break label293;
        }
        localObject = paramString;
        label162:
        StringBuilder localStringBuilder = new StringBuilder((String)localObject);
        m = 0;
        k = 0;
        i = 0;
        label182:
        if (m >= arrayOfChar.length - j) {
          break label393;
        }
        localStringBuilder.append(arrayOfChar[m]);
        if (paramTextPaint.measureText(localStringBuilder.toString()) <= paramInt1 * paramInt2) {
          break label313;
        }
      }
      for (paramInt1 = m - 2;; paramInt1 = i)
      {
        if (paramInt1 > 0) {}
        for (;;)
        {
          if (k != 0) {
            break label368;
          }
          return paramString.substring(0, paramInt1) + jdField_a_of_type_JavaLangString + (String)localObject;
          j = 1;
          break;
          label273:
          i = n + 1;
          k = m;
          break label54;
          j = 15;
          break label150;
          label293:
          localObject = paramString.substring(paramString.length() - j, paramString.length());
          break label162;
          label313:
          if (paramString.substring(m, m + 1).equals(jdField_a_of_type_JavaLangString)) {
            k = 1;
          }
          if (m == arrayOfChar.length - j - 1) {
            i = m - 2;
          }
          m += 1;
          break label182;
          paramInt1 = 0;
        }
        label368:
        return paramString.substring(0, paramInt1) + (String)localObject;
      }
    }
  }
  
  public static String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  public static ArrayList a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    Object localObject2 = new File(b()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (i < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[i];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (FileUtil.a((String)localObject2))
          {
            localObject2 = new File((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).d(((File)localObject2).getName());
            ((FileInfo)localObject3).a(((File)localObject2).isDirectory());
            ((FileInfo)localObject3).e(((File)localObject2).getPath());
            ((FileInfo)localObject3).a(((File)localObject2).length());
            ((FileInfo)localObject3).b(((File)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label290;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new FileUtil.MyFileCompare());
    for (;;)
    {
      return localArrayList;
      label290:
      Collections.sort(localArrayList, new FileCompare());
    }
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int i = 0;
    if (i < paramString.length)
    {
      localObject = paramString[i].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
    }
    return localLinkedHashMap;
  }
  
  /* Error */
  @TargetApi(9)
  public static Map a(Context paramContext)
  {
    // Byte code:
    //   0: new 107	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 1713	java/util/HashMap:<init>	(I)V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 1715
    //   16: invokestatic 1721	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: invokeinterface 1722 3 0
    //   24: pop
    //   25: aload_0
    //   26: ldc_w 1724
    //   29: invokevirtual 1728	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 1730	android/os/storage/StorageManager
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 1734	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: ldc_w 1736
    //   45: aconst_null
    //   46: invokevirtual 1740	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   49: aload 5
    //   51: aconst_null
    //   52: invokevirtual 1746	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 1748	[Ljava/lang/String;
    //   58: checkcast 1748	[Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: iload_3
    //   71: if_icmpge +166 -> 237
    //   74: aload 5
    //   76: iload_1
    //   77: aaload
    //   78: astore 6
    //   80: new 436	java/io/File
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 439	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 7
    //   91: getstatic 1753	android/os/Build$VERSION:SDK_INT	I
    //   94: bipush 9
    //   96: if_icmple +357 -> 453
    //   99: aload 7
    //   101: invokevirtual 1756	java/io/File:getUsableSpace	()J
    //   104: lconst_0
    //   105: lcmp
    //   106: ifgt +6 -> 112
    //   109: goto +344 -> 453
    //   112: aload 4
    //   114: invokeinterface 1758 1 0
    //   119: ifne +64 -> 183
    //   122: aload 4
    //   124: invokeinterface 1759 1 0
    //   129: invokeinterface 142 1 0
    //   134: astore 8
    //   136: aload 8
    //   138: invokeinterface 148 1 0
    //   143: ifeq +305 -> 448
    //   146: aload 4
    //   148: aload 8
    //   150: invokeinterface 152 1 0
    //   155: checkcast 17	java/lang/String
    //   158: invokeinterface 1303 2 0
    //   163: checkcast 436	java/io/File
    //   166: invokevirtual 1612	java/io/File:getPath	()Ljava/lang/String;
    //   169: aload 6
    //   171: invokevirtual 1362	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   174: iconst_1
    //   175: if_icmpne -39 -> 136
    //   178: iconst_1
    //   179: istore_2
    //   180: goto +280 -> 460
    //   183: ldc_w 378
    //   186: iconst_1
    //   187: new 154	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 1761
    //   197: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 7
    //   202: invokevirtual 1612	java/io/File:getPath	()Ljava/lang/String;
    //   205: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 4
    //   216: ldc_w 1763
    //   219: aload 7
    //   221: invokeinterface 1722 3 0
    //   226: pop
    //   227: goto +226 -> 453
    //   230: astore 5
    //   232: aload 5
    //   234: invokevirtual 1764	java/lang/IllegalArgumentException:printStackTrace	()V
    //   237: aload 4
    //   239: ldc_w 1763
    //   242: invokeinterface 1765 2 0
    //   247: ifne +111 -> 358
    //   250: aload_0
    //   251: aconst_null
    //   252: invokevirtual 1769	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +144 -> 401
    //   260: ldc_w 378
    //   263: iconst_1
    //   264: new 154	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 1771
    //   274: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 1612	java/io/File:getPath	()Ljava/lang/String;
    //   281: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: invokevirtual 1774	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   294: aload 4
    //   296: ldc_w 1715
    //   299: invokeinterface 1303 2 0
    //   304: checkcast 436	java/io/File
    //   307: invokevirtual 1774	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   310: invokevirtual 1777	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifne +45 -> 358
    //   316: ldc_w 378
    //   319: iconst_1
    //   320: new 154	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 1779
    //   330: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 1612	java/io/File:getPath	()Ljava/lang/String;
    //   337: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload 4
    //   348: ldc_w 1763
    //   351: aload_0
    //   352: invokeinterface 1722 3 0
    //   357: pop
    //   358: aload 4
    //   360: areturn
    //   361: astore 5
    //   363: aload 5
    //   365: invokevirtual 1780	java/lang/IllegalAccessException:printStackTrace	()V
    //   368: goto -131 -> 237
    //   371: astore 5
    //   373: aload 5
    //   375: invokevirtual 1781	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   378: goto -141 -> 237
    //   381: astore 5
    //   383: aload 5
    //   385: invokevirtual 1782	java/lang/NoSuchMethodException:printStackTrace	()V
    //   388: goto -151 -> 237
    //   391: astore 5
    //   393: aload 5
    //   395: invokevirtual 1480	java/lang/Exception:printStackTrace	()V
    //   398: goto -161 -> 237
    //   401: ldc_w 378
    //   404: iconst_1
    //   405: ldc_w 1784
    //   408: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 4
    //   413: areturn
    //   414: astore_0
    //   415: ldc_w 378
    //   418: iconst_1
    //   419: new 154	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 1786
    //   429: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_0
    //   433: invokevirtual 1787	java/lang/Exception:toString	()Ljava/lang/String;
    //   436: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 4
    //   447: areturn
    //   448: iconst_0
    //   449: istore_2
    //   450: goto +10 -> 460
    //   453: iload_1
    //   454: iconst_1
    //   455: iadd
    //   456: istore_1
    //   457: goto -388 -> 69
    //   460: iload_2
    //   461: iconst_1
    //   462: if_icmpeq -9 -> 453
    //   465: goto -282 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContext	Context
    //   68	389	1	i	int
    //   179	284	2	j	int
    //   66	6	3	k	int
    //   9	437	4	localHashMap	HashMap
    //   35	40	5	localObject	Object
    //   230	3	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   361	3	5	localIllegalAccessException	java.lang.IllegalAccessException
    //   371	3	5	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   381	3	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   391	3	5	localException	Exception
    //   78	92	6	str	String
    //   89	131	7	localFile	File
    //   134	15	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   11	67	230	java/lang/IllegalArgumentException
    //   80	109	230	java/lang/IllegalArgumentException
    //   112	136	230	java/lang/IllegalArgumentException
    //   136	178	230	java/lang/IllegalArgumentException
    //   183	227	230	java/lang/IllegalArgumentException
    //   11	67	361	java/lang/IllegalAccessException
    //   80	109	361	java/lang/IllegalAccessException
    //   112	136	361	java/lang/IllegalAccessException
    //   136	178	361	java/lang/IllegalAccessException
    //   183	227	361	java/lang/IllegalAccessException
    //   11	67	371	java/lang/reflect/InvocationTargetException
    //   80	109	371	java/lang/reflect/InvocationTargetException
    //   112	136	371	java/lang/reflect/InvocationTargetException
    //   136	178	371	java/lang/reflect/InvocationTargetException
    //   183	227	371	java/lang/reflect/InvocationTargetException
    //   11	67	381	java/lang/NoSuchMethodException
    //   80	109	381	java/lang/NoSuchMethodException
    //   112	136	381	java/lang/NoSuchMethodException
    //   136	178	381	java/lang/NoSuchMethodException
    //   183	227	381	java/lang/NoSuchMethodException
    //   11	67	391	java/lang/Exception
    //   80	109	391	java/lang/Exception
    //   112	136	391	java/lang/Exception
    //   136	178	391	java/lang/Exception
    //   183	227	391	java/lang/Exception
    //   250	256	414	java/lang/Exception
    //   260	358	414	java/lang/Exception
    //   401	411	414	java/lang/Exception
  }
  
  public static void a()
  {
    ThreadManager.post(new adpz(), 8, null, false);
  }
  
  private static void a(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(d(paramFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131428197));
  }
  
  public static void a(long paramLong)
  {
    Object localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(paramLong);
    if (localObject == null) {}
    do
    {
      return;
      switch (((FileManagerEntity)localObject).nOpType)
      {
      case -1: 
      case 0: 
      case 3: 
      case 7: 
      case 2: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        return;
      case 1: 
      case 5: 
      case 8: 
        localObject = d(((FileManagerEntity)localObject).fileName);
        FMToastUtil.c((String)localObject + BaseApplicationImpl.getContext().getString(2131428147) + FMSettings.a().b());
        return;
      }
      if (((FileManagerEntity)localObject).nOpType == 6)
      {
        FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131429825));
        return;
      }
    } while (!ResponseHandler.a(0));
    FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131429825));
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = localQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null) {}
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
              do
              {
                return;
                switch (localFileManagerEntity.nOpType)
                {
                case -1: 
                case 2: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                default: 
                  return;
                }
              } while (a(paramInt, localFileManagerEntity.fileName));
              if ((paramString == null) || (paramString.length() <= 0)) {
                break;
              }
              a(paramString);
              return;
              if ((paramString != null) && (paramString.length() > 0))
              {
                a(paramString);
                return;
              }
            } while (a(paramInt, localFileManagerEntity.fileName));
            a(13, localFileManagerEntity.fileName);
            return;
            if (localFileManagerEntity.nOpType != 4) {
              break;
            }
          } while (!ResponseHandler.a(paramInt));
          if (ResponseHandler.b())
          {
            ResponseHandler.a(localQQAppInterface);
            return;
          }
          a(paramInt, paramString, localFileManagerEntity);
          return;
          a(paramInt, paramString, localFileManagerEntity);
          return;
        } while (!ResponseHandler.a(paramInt));
        if (ResponseHandler.b())
        {
          ResponseHandler.a(localQQAppInterface);
          return;
        }
      } while (a(paramInt, localFileManagerEntity.fileName));
      if ((paramString != null) && (paramString.length() > 0))
      {
        a(paramString);
        return;
      }
      a(11, localFileManagerEntity.fileName);
      return;
    } while (a(paramInt, localFileManagerEntity.fileName));
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(11, localFileManagerEntity.fileName);
    return;
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(13, localFileManagerEntity.fileName);
    return;
    a(13, localFileManagerEntity.fileName);
    return;
    a(paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      FMToastUtil.a(2131428218);
      return;
    }
    ThreadManager.post(new adpy(paramString, paramActivity, localFile), 8, null, true);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    paramActivity.startActivityForResult(localIntent, 106);
    paramActivity.overridePendingTransition(2131034123, 2131034124);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 1, paramString1);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 6);
    localIntent.putExtra("from_qlink", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 108);
    paramActivity.overridePendingTransition(2131034132, 2131034133);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "[QFILE] QQ - startQFile failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), "加载失败，请重试", 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QfileFileAssistantActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("COMEFROMDESK", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    FileModel.a(paramFileManagerEntity).a(paramBoolean, paramContext, new adqa(paramFileManagerEntity, paramQQAppInterface));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    WebAccelerator.a(paramContext, localIntent, paramString);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent2 = new Intent("android.intent.action.MAIN");
    localIntent2.addCategory("android.intent.category.LAUNCHER");
    localIntent2.putExtra(paramString1, true);
    localIntent2.setClassName(paramContext, JumpActivity.class.getName());
    Intent localIntent1 = new Intent();
    localIntent2.setFlags(337641472);
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramString2);
    paramString1 = new BitmapFactory.Options();
    paramString1.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramContext.getResources(), paramInt, paramString1);
    paramString1.inSampleSize = 1;
    paramString1.inJustDecodeBounds = false;
    try
    {
      paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), paramInt, paramString1);
      paramInt = DisplayUtils.a(paramContext);
      paramString1 = paramString2;
      if (paramString2.getWidth() != paramInt) {
        if (MobileIssueSettings.c) {
          break label227;
        }
      }
      label227:
      for (paramString1 = KapalaiAdapterUtil.a().a(paramString2, paramInt);; paramString1 = Bitmap.createScaledBitmap(paramString2, paramInt, paramInt, false))
      {
        localIntent1.putExtra("android.intent.extra.shortcut.ICON", paramString1);
        localIntent1.putExtra("duplicate", false);
        localIntent1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        paramContext.sendBroadcast(localIntent1);
        paramContext = paramContext.getSharedPreferences("Offline_Flags", 0).edit();
        paramContext.clear();
        paramContext.putBoolean("TMPFLAG", true).commit();
        return;
      }
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130841697);
      return;
    }
    paramImageView.setImageResource(b(paramString));
  }
  
  public static void a(TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str3 = FileUtil.a(paramDataLineMsgRecord.filename);
    if (str3 == null)
    {
      paramAsyncImageView.setImageResource(2130841697);
      label20:
      return;
    }
    String str2 = paramDataLineMsgRecord.filename;
    String str1 = str2;
    if (a(str3) == 0)
    {
      if (!FileUtils.b(paramDataLineMsgRecord.path)) {
        break label100;
      }
      str1 = paramDataLineMsgRecord.path;
    }
    for (;;)
    {
      paramAsyncImageView.setDefaultImage(b(str3));
      switch (a(str3))
      {
      default: 
        int i = b(str3);
        if (i == 0) {
          break label20;
        }
        paramAsyncImageView.setImageResource(i);
        return;
        label100:
        str1 = str2;
        if (FileUtils.b(paramDataLineMsgRecord.thumbPath)) {
          str1 = paramDataLineMsgRecord.thumbPath;
        }
        break;
      }
    }
    paramAsyncImageView.setAsyncClipSize(128, 128);
    paramAsyncImageView.setAsyncImage(str1);
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838600);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int k = FMConfig.a();
    if (k == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "aio switch is off,return!");
      }
    }
    FileManagerEntity localFileManagerEntity;
    long l;
    do
    {
      String str;
      int i;
      SharedPreferences.Editor localEditor;
      do
      {
        do
        {
          SharedPreferences localSharedPreferences;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  str = "showTime_" + paramQQAppInterface.getCurrentAccountUin();
                  localFileManagerEntity = paramQQAppInterface.a().b(paramLong);
                  if (localFileManagerEntity != null) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "entity is null! return");
                return;
                int j = a(localFileManagerEntity.fileName);
                if (j != -1)
                {
                  i = j;
                  if (j != 11) {}
                }
                else
                {
                  i = a(localFileManagerEntity.getFilePath());
                }
                if ((i == 3) || (i == 6)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "File type wrong, return!");
              return;
              if ((localFileManagerEntity.peerType == 0) || (localFileManagerEntity.peerType == 3000)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "aio[" + localFileManagerEntity.peerType + "] not buddy or disc, return!");
            return;
            localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
            localEditor = localSharedPreferences.edit();
            i = localSharedPreferences.getInt("AIOshowTime_Total", 0);
            if (i < k) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "more then total return!");
          return;
          paramLong = localSharedPreferences.getLong(str, 0L);
          l = MessageCache.a();
          if (l - paramLong >= 86400000L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "less OneDay return!");
        return;
        if (!PackageUtil.a(paramQQAppInterface.getApp().getBaseContext(), "com.tencent.tim")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return!");
      return;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new adpt(paramQQAppInterface, localFileManagerEntity), 1000L);
      localEditor.putLong(str, l);
      localEditor.putInt("AIOshowTime_Total", i + 1);
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "lastShowTime[" + l + "],[" + e(localFileManagerEntity.peerUin) + "]add new aiograyTips!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        label74:
        break label74;
      }
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("param_Server", String.valueOf(paramString2));
      localHashMap.put("param_ftnIP", String.valueOf(paramString2));
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
      if (QLog.isColorLevel()) {
        QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString6) + "]");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    long l = paramLong2;
    if (paramLong2 == 0L) {
      l = System.currentTimeMillis();
    }
    if (l < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          int j = 0;
          int i = j;
          if (paramString9 != null)
          {
            i = j;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label776;
              }
              i = 1;
            }
          }
          for (;;)
          {
            if (NetworkUtil.d(BaseApplication.getContext()))
            {
              paramString2 = paramString9;
              if (i == 0) {}
            }
            else
            {
              paramLong3 = 9004L;
              paramString2 = paramString9 + "_NotNetWork";
            }
            paramString9 = paramString2;
            if (!paramQQAppInterface.isLogin())
            {
              paramLong3 = 9004L;
              paramString9 = paramString2 + "_NotLogin";
            }
            paramString2 = new HashMap();
            paramString2.put("serverip", String.valueOf(str1));
            paramString2.put("param_Server", String.valueOf(str1));
            paramString2.put("param_ftnIP", String.valueOf(str1));
            paramString2.put("param_PeerUin", String.valueOf(paramString3));
            paramString2.put("param_uuid", String.valueOf(paramString4));
            paramString2.put("param_MD5", paramString5);
            paramString2.put("param_FailCode", Long.toString(paramLong3));
            paramString2.put("param_errorDesc", String.valueOf(paramString6));
            paramString2.put("param_fsized", String.valueOf(paramLong5));
            paramString2.put("param_fsizeo", String.valueOf(paramLong6));
            paramString2.put("param_url", String.valueOf(paramString7));
            paramString2.put("param_rspHeader", String.valueOf(paramString8));
            paramString2.put("param_retry", String.valueOf(paramInt));
            paramString2.put("param_errMsg", String.valueOf(paramString9 + "uin[" + paramQQAppInterface.getCurrentAccountUin() + "]"));
            paramString2.put("param_nSessionId", String.valueOf(paramLong1));
            StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
            if (QLog.isColorLevel()) {
              QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString6) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString10) + "]");
            }
            if (QLog.isColorLevel()) {
              QLog.e("@@@@@@@", 2, "ReportFilemanagerInfo Color Log actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], errMsg[" + String.valueOf(paramString9) + "]");
            }
            return;
            paramLong2 = System.currentTimeMillis() - l;
            break;
            label776:
            if (paramString9.indexOf("No route to host") > 0)
            {
              i = 1;
            }
            else
            {
              i = j;
              if (paramString9.indexOf("MalformedURLException") > 0) {
                i = 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (!paramFileManagerEntity.bSend)
    {
      paramQQAppInterface = new adqc();
      DialogUtil.b(paramContext, 230, paramContext.getString(2131431892), paramContext.getString(2131431891), 2131433025, 2131433030, paramQQAppInterface, null).show();
      return;
    }
    paramQQAppInterface = paramContext.getString(2131428109);
    paramFileManagerEntity = paramContext.getString(2131428107);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.c(paramQQAppInterface);
    localActionSheet.d(paramContext.getString(2131433029));
    localActionSheet.a(paramFileManagerEntity);
    localActionSheet.a(new adqd(localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    if (paramChatMessage == null) {}
    adpv localadpv;
    int i;
    do
    {
      do
      {
        return;
      } while (!(paramChatMessage instanceof MessageForFile));
      Object localObject = a(paramQQAppInterface, (MessageForFile)paramChatMessage);
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", 0);
      paramChatMessage.putBoolean("not_forward", true);
      paramChatMessage.putInt("dataline_forward_type", 100);
      paramChatMessage.putString("dataline_forward_path", ((FileManagerEntity)localObject).getFilePath());
      paramChatMessage.putParcelable("fileinfo", ForwardFileOption.a((FileManagerEntity)localObject));
      localObject = (DataLineHandler)paramQQAppInterface.a(8);
      localadpv = new adpv(paramContext);
      i = ((DataLineHandler)localObject).a().b(AppConstants.y, paramChatMessage, localadpv);
    } while ((localadpv.jdField_a_of_type_Boolean) && (i != 0));
    if (i == 0) {}
    DirectForwarder.b(paramContext, i);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label315:
    label317:
    label328:
    label472:
    do
    {
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
                Object localObject = paramFileManagerEntity.peerUin;
                if (paramFileManagerEntity.peerType == 3000) {
                  localObject = paramFileManagerEntity.selfUin;
                }
                localObject = localFriendsManager.c((String)localObject);
                int i = -1;
                if (localObject != null) {
                  i = ((Friends)localObject).iTermType;
                }
                j = a(paramFileManagerEntity.fileName);
                if (j == 0) {
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] PicFile, from device[" + i + "] size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
                for (;;)
                {
                  if ((!FMConfig.a()) && (a())) {
                    break label315;
                  }
                  if (j != 0) {
                    break label472;
                  }
                  if (!FilePicURLDrawlableHelper.b(paramFileManagerEntity)) {
                    break label328;
                  }
                  paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is badPic Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
                  return;
                  if (j != 2) {
                    break label317;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] VideoFile, from device[" + i + "] Preload VideoThumb size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
              }
              QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
              return;
              paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 5);
              if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] Preload 384 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
              }
            } while (a());
            paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
          } while (!QLog.isColorLevel());
          QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is Wi-Fi Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
          return;
        } while (j != 2);
        if (paramFileManagerEntity.peerType != 3000) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(paramFileManagerEntity);
      } while (paramQQAppInterface == null);
      paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
      return;
      paramQQAppInterface = paramQQAppInterface.a().a(paramFileManagerEntity);
    } while (paramQQAppInterface == null);
    paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 12
    //   6: new 436	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 2133	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   14: invokevirtual 2452	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   17: ldc_w 2454
    //   20: invokespecial 2457	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 13
    //   25: aload_1
    //   26: ldc_w 1346
    //   29: ldc_w 2459
    //   32: invokevirtual 1686	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   35: pop
    //   36: iconst_5
    //   37: istore 5
    //   39: iload 5
    //   41: ifle +515 -> 556
    //   44: new 2461	java/net/URL
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 2462	java/net/URL:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 2466	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   55: checkcast 2468	java/net/HttpURLConnection
    //   58: astore 7
    //   60: aload 7
    //   62: sipush 30000
    //   65: invokevirtual 2471	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload 7
    //   70: sipush 30000
    //   73: invokevirtual 2474	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   76: aload 7
    //   78: ldc_w 2476
    //   81: ldc_w 2478
    //   84: invokevirtual 2481	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 7
    //   89: invokevirtual 2485	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   92: astore 8
    //   94: new 1214	java/io/FileOutputStream
    //   97: dup
    //   98: aload 13
    //   100: invokespecial 1217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore 10
    //   105: sipush 4096
    //   108: newarray byte
    //   110: astore 9
    //   112: aload 8
    //   114: aload 9
    //   116: invokevirtual 2491	java/io/InputStream:read	([B)I
    //   119: istore 6
    //   121: iload 6
    //   123: iconst_m1
    //   124: if_icmpeq +113 -> 237
    //   127: aload 10
    //   129: aload 9
    //   131: iconst_0
    //   132: iload 6
    //   134: invokevirtual 2495	java/io/FileOutputStream:write	([BII)V
    //   137: goto -25 -> 112
    //   140: astore 11
    //   142: aload 7
    //   144: astore 9
    //   146: aload 10
    //   148: astore 7
    //   150: aload 11
    //   152: astore 10
    //   154: aload 10
    //   156: invokevirtual 1480	java/lang/Exception:printStackTrace	()V
    //   159: aload 9
    //   161: ifnull +8 -> 169
    //   164: aload 9
    //   166: invokevirtual 2498	java/net/HttpURLConnection:disconnect	()V
    //   169: aload 8
    //   171: ifnull +8 -> 179
    //   174: aload 8
    //   176: invokevirtual 2499	java/io/InputStream:close	()V
    //   179: aload 7
    //   181: ifnull +8 -> 189
    //   184: aload 7
    //   186: invokevirtual 2500	java/io/FileOutputStream:close	()V
    //   189: iload 4
    //   191: ifeq +196 -> 387
    //   194: iload 4
    //   196: ifeq +240 -> 436
    //   199: new 2502	com/tencent/mobileqq/filemanager/util/FileManagerUtil$PreViewDataHandler
    //   202: dup
    //   203: invokespecial 2503	com/tencent/mobileqq/filemanager/util/FileManagerUtil$PreViewDataHandler:<init>	()V
    //   206: astore_1
    //   207: invokestatic 2509	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   210: invokevirtual 2513	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   213: aload 13
    //   215: aload_1
    //   216: invokevirtual 2519	javax/xml/parsers/SAXParser:parse	(Ljava/io/File;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   219: new 2113	com/tencent/mobileqq/filemanager/data/FMConfig
    //   222: dup
    //   223: aload_0
    //   224: aload_1
    //   225: lload_2
    //   226: invokespecial 2522	com/tencent/mobileqq/filemanager/data/FMConfig:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/filemanager/util/FileManagerUtil$PreViewDataHandler;J)V
    //   229: pop
    //   230: aload 13
    //   232: invokevirtual 2524	java/io/File:delete	()Z
    //   235: pop
    //   236: return
    //   237: aload 7
    //   239: ifnull +8 -> 247
    //   242: aload 7
    //   244: invokevirtual 2498	java/net/HttpURLConnection:disconnect	()V
    //   247: aload 8
    //   249: ifnull +8 -> 257
    //   252: aload 8
    //   254: invokevirtual 2499	java/io/InputStream:close	()V
    //   257: aload 10
    //   259: ifnull +8 -> 267
    //   262: aload 10
    //   264: invokevirtual 2500	java/io/FileOutputStream:close	()V
    //   267: iconst_1
    //   268: istore 4
    //   270: goto -81 -> 189
    //   273: astore 7
    //   275: aload 7
    //   277: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   280: iconst_1
    //   281: istore 4
    //   283: goto -94 -> 189
    //   286: astore 7
    //   288: aload 7
    //   290: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   293: goto -104 -> 189
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 2498	java/net/HttpURLConnection:disconnect	()V
    //   304: aload 8
    //   306: ifnull +8 -> 314
    //   309: aload 8
    //   311: invokevirtual 2499	java/io/InputStream:close	()V
    //   314: aload 7
    //   316: ifnull +8 -> 324
    //   319: aload 7
    //   321: invokevirtual 2500	java/io/FileOutputStream:close	()V
    //   324: aload_0
    //   325: athrow
    //   326: astore_0
    //   327: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +33 -> 363
    //   333: ldc_w 378
    //   336: iconst_2
    //   337: new 154	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 2526
    //   347: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_0
    //   351: invokestatic 2530	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   354: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 766	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload 13
    //   365: invokevirtual 2524	java/io/File:delete	()Z
    //   368: pop
    //   369: return
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   375: goto -51 -> 324
    //   378: astore_0
    //   379: aload 13
    //   381: invokevirtual 2524	java/io/File:delete	()Z
    //   384: pop
    //   385: aload_0
    //   386: athrow
    //   387: iload 5
    //   389: iconst_1
    //   390: isub
    //   391: istore 5
    //   393: goto -354 -> 39
    //   396: astore_0
    //   397: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq -170 -> 230
    //   403: ldc_w 378
    //   406: iconst_2
    //   407: new 154	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 2526
    //   417: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: invokestatic 2530	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   424: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 766	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto -203 -> 230
    //   436: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq -209 -> 230
    //   442: ldc_w 378
    //   445: iconst_2
    //   446: new 154	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 2532
    //   456: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_1
    //   460: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 766	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto -239 -> 230
    //   472: astore_0
    //   473: aconst_null
    //   474: astore 8
    //   476: aload 7
    //   478: astore_1
    //   479: aload 12
    //   481: astore 7
    //   483: goto -187 -> 296
    //   486: astore_0
    //   487: aload 7
    //   489: astore_1
    //   490: aload 12
    //   492: astore 7
    //   494: goto -198 -> 296
    //   497: astore_0
    //   498: aload 7
    //   500: astore_1
    //   501: aload 10
    //   503: astore 7
    //   505: goto -209 -> 296
    //   508: astore_0
    //   509: aload 9
    //   511: astore_1
    //   512: goto -216 -> 296
    //   515: astore 10
    //   517: aconst_null
    //   518: astore 7
    //   520: aconst_null
    //   521: astore 8
    //   523: aconst_null
    //   524: astore 9
    //   526: goto -372 -> 154
    //   529: astore 10
    //   531: aconst_null
    //   532: astore 8
    //   534: aload 7
    //   536: astore 9
    //   538: aconst_null
    //   539: astore 7
    //   541: goto -387 -> 154
    //   544: astore 10
    //   546: aload 7
    //   548: astore 9
    //   550: aconst_null
    //   551: astore 7
    //   553: goto -399 -> 154
    //   556: goto -362 -> 194
    //   559: astore_0
    //   560: aconst_null
    //   561: astore 8
    //   563: aconst_null
    //   564: astore_1
    //   565: aload 12
    //   567: astore 7
    //   569: goto -273 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramQQAppInterface	QQAppInterface
    //   0	572	1	paramString	String
    //   0	572	2	paramLong	long
    //   1	281	4	i	int
    //   37	355	5	j	int
    //   119	14	6	k	int
    //   58	185	7	localObject1	Object
    //   273	3	7	localIOException1	IOException
    //   286	191	7	localIOException2	IOException
    //   481	87	7	localObject2	Object
    //   92	470	8	localInputStream	java.io.InputStream
    //   110	439	9	localObject3	Object
    //   103	399	10	localObject4	Object
    //   515	1	10	localException1	Exception
    //   529	1	10	localException2	Exception
    //   544	1	10	localException3	Exception
    //   140	11	11	localException4	Exception
    //   4	562	12	localObject5	Object
    //   23	357	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	112	140	java/lang/Exception
    //   112	121	140	java/lang/Exception
    //   127	137	140	java/lang/Exception
    //   252	257	273	java/io/IOException
    //   262	267	273	java/io/IOException
    //   174	179	286	java/io/IOException
    //   184	189	286	java/io/IOException
    //   25	36	326	java/lang/Exception
    //   164	169	326	java/lang/Exception
    //   174	179	326	java/lang/Exception
    //   184	189	326	java/lang/Exception
    //   199	207	326	java/lang/Exception
    //   207	230	326	java/lang/Exception
    //   242	247	326	java/lang/Exception
    //   252	257	326	java/lang/Exception
    //   262	267	326	java/lang/Exception
    //   275	280	326	java/lang/Exception
    //   288	293	326	java/lang/Exception
    //   300	304	326	java/lang/Exception
    //   309	314	326	java/lang/Exception
    //   319	324	326	java/lang/Exception
    //   324	326	326	java/lang/Exception
    //   371	375	326	java/lang/Exception
    //   397	433	326	java/lang/Exception
    //   436	469	326	java/lang/Exception
    //   309	314	370	java/io/IOException
    //   319	324	370	java/io/IOException
    //   25	36	378	finally
    //   164	169	378	finally
    //   174	179	378	finally
    //   184	189	378	finally
    //   199	207	378	finally
    //   207	230	378	finally
    //   242	247	378	finally
    //   252	257	378	finally
    //   262	267	378	finally
    //   275	280	378	finally
    //   288	293	378	finally
    //   300	304	378	finally
    //   309	314	378	finally
    //   319	324	378	finally
    //   324	326	378	finally
    //   327	363	378	finally
    //   371	375	378	finally
    //   397	433	378	finally
    //   436	469	378	finally
    //   207	230	396	java/lang/Throwable
    //   60	94	472	finally
    //   94	105	486	finally
    //   105	112	497	finally
    //   112	121	497	finally
    //   127	137	497	finally
    //   154	159	508	finally
    //   44	60	515	java/lang/Exception
    //   60	94	529	java/lang/Exception
    //   94	105	544	java/lang/Exception
    //   44	60	559	finally
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    int i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-1_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-1_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-2_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-2_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-3_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-3_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Complete_download_2_1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Complete_download_2_0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", null, null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "0", null, null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new adpu(paramString2, paramQQAppInterface, paramInt, paramString1), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, a());
      }
      return;
    }
    int i = (int)a(paramFileManagerEntity.peerType);
    QLog.i("FileManagerUtil<FileAssistant>", 2, "=_= Id[" + paramFileManagerEntity.nSessionId + "],setTempParam[" + i + "]");
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, i);
    switch (i)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("from_qlink_enter_recent", paramBaseFileAssistantActivity.g());
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.nFileType == -1) || (paramFileManagerEntity.nFileType == 5))
    {
      if (paramFileManagerEntity.getFilePath() != null) {
        paramFileManagerEntity.nFileType = a(paramFileManagerEntity.getFilePath());
      }
    }
    else {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.status = 2;
    paramQQAppInterface.a().d(localFileManagerEntity);
    paramQQAppInterface = ForwardFileOption.a(localFileManagerEntity);
    paramQQAppInterface.b(paramInt);
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putInt("forward_type", 0);
    paramFileManagerEntity.putParcelable("fileinfo", paramQQAppInterface);
    paramFileManagerEntity.putBoolean("not_forward", true);
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtras(paramFileManagerEntity);
    paramQQAppInterface.putExtra("destroy_last_activity", true);
    paramQQAppInterface.putExtra("forward_type", 0);
    paramQQAppInterface.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramQQAppInterface.putExtra("forward_text", "已选择" + d(localFileManagerEntity.fileName) + "，大小" + FileUtil.a(localFileManagerEntity.fileSize) + "。");
    paramQQAppInterface.putExtra("k_favorites", c(localFileManagerEntity));
    if (((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramQQAppInterface.putExtra("forward_type", 1);
    }
    ForwardBaseOption.a(paramActivity, paramQQAppInterface, 103);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (FileUtils.b(paramFileManagerEntity.strLargeThumPath))
      {
        str = paramFileManagerEntity.strLargeThumPath;
      }
      else if (FileUtils.b(paramFileManagerEntity.getFilePath()))
      {
        str = paramFileManagerEntity.getFilePath();
        ThreadManager.executeOnSubThread(new adpn(paramFileManagerEntity));
        continue;
        if (paramFileManagerEntity.nFileType == 2) {
          if (FileUtils.b(paramFileManagerEntity.strLargeThumPath)) {
            str = paramFileManagerEntity.strLargeThumPath;
          } else {
            str = null;
          }
        }
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setImageResource(a(a(paramString)));
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramAsyncImageView.setImageResource(a(paramInt));
    }
    do
    {
      do
      {
        return;
        paramAsyncImageView.setDefaultImage(2130841666);
        paramAsyncImageView.setAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130841628);
      } while (!FileUtil.b(paramString));
      paramAsyncImageView.setApkIconAsyncImage(paramString);
      return;
      paramAsyncImageView.setDefaultImage(2130841698);
    } while (!FileUtil.b(paramString));
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = FileUtil.a(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130841697);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(b(paramString));
    } while (!paramBoolean);
    switch (a(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130841666);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130841698);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, FileManagerUtil.IGetVideoCallback paramIGetVideoCallback)
  {
    ThreadManager.post(new adpp(paramString, paramInt3, paramBoolean, paramIGetVideoCallback, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void a(List paramList, Activity paramActivity)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      long l1 = 0L;
      do
      {
        l2 = l1;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (FileManagerEntity)paramList.next();
      } while (((FileManagerEntity)localObject).sendCloudUnsuccessful());
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10001);
      localForwardFileInfo.d(((FileManagerEntity)localObject).getCloudType());
      localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileName);
      localForwardFileInfo.c(((FileManagerEntity)localObject).uniseq);
      localForwardFileInfo.c(((FileManagerEntity)localObject).WeiYunFileId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileSize);
      localForwardFileInfo.a(((FileManagerEntity)localObject).getFilePath());
      localForwardFileInfo.b(((FileManagerEntity)localObject).Uuid);
      if ((((FileManagerEntity)localObject).getCloudType() == 3) && (((FileManagerEntity)localObject).getFilePath() != null) && (((FileManagerEntity)localObject).getFilePath().length() > 0)) {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject).getFilePath()));
      }
      for (;;)
      {
        l2 = localForwardFileInfo.d();
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        localArrayList2.add(Uri.parse(""));
      }
    }
    long l2 = 0L;
    paramList = new Bundle();
    Object localObject = new Intent();
    paramList.putInt("forward_type", 0);
    paramList.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramList.putBoolean("not_forward", true);
    ((Intent)localObject).putExtra("sendMultiple", true);
    paramList.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    ((Intent)localObject).putExtras(paramList);
    ((Intent)localObject).putExtra("foward_editbar", true);
    ((Intent)localObject).putExtra("forward_type", 0);
    paramList = "转发文件";
    if (localArrayList1.size() == 1) {
      paramList = "已选择" + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "，大小" + FileUtil.a(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("forward_text", paramList);
      ((Intent)localObject).putExtra("k_favorites", false);
      ForwardBaseOption.a(paramActivity, (Intent)localObject, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramList = "已选择" + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "等" + localArrayList1.size() + "个文件，大小" + FileUtil.a(l2) + "。";
      }
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(2131437332);
      return;
    }
    if (!a())
    {
      paramFMDialogInterface.a();
      return;
    }
    Activity localActivity = (Activity)paramContext;
    if (paramBoolean)
    {
      i = 3;
      label41:
      if (!CUKingCardHelper.a(localActivity, i, new adpx(paramFMDialogInterface), "")) {
        break label82;
      }
      if (!paramBoolean) {
        break label84;
      }
    }
    label82:
    label84:
    for (int i = 2131428237;; i = 2131428239)
    {
      FMDialogUtil.a(paramContext, 2131428241, i, paramFMDialogInterface);
      return;
      i = 2;
      break label41;
      break;
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == FMConstants.jdField_a_of_type_Int;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + String.valueOf(paramInt));
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428188));
      return true;
    case 2: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 3: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428188));
      return true;
    case 4: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428188));
      return true;
    case 5: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 6: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 7: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 9: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 10: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 11: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    case 12: 
      if (QLog.isDevelopLevel()) {
        a();
      }
      FMToastUtil.a(2131428202);
      return true;
    case 16: 
      FMToastUtil.a(2131428203);
      return true;
    case 13: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131428193));
      return true;
    }
    FMToastUtil.a(2131428267);
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {}
    while ((a()) || (paramLong >= 3145728L)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = FMConfig.a(paramContext, paramString, "FileMaxSize");
    if (paramContext == null) {}
    while (Integer.parseInt(paramContext) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int m = FMConfig.d();
    int k = FMConfig.c();
    if (k == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "FileBrowser : TimFAViewDayCount is 0,return!");
      }
      return false;
    }
    if (m == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "FileBrowser : TimFAViewTotal is 0,return!");
      }
      return false;
    }
    String str1 = "FileBrowserShowTotal_" + paramQQAppInterface.getCurrentAccountUin();
    String str2 = "FileBrowserShowTime_" + paramQQAppInterface.getCurrentAccountUin();
    String str3 = "FileBrowserShowDayCount_" + paramQQAppInterface.getCurrentAccountUin();
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "FileBrowser : entity is null! return");
      }
      return false;
    }
    int j = a(localFileManagerEntity.fileName);
    if (j != -1)
    {
      i = j;
      if (j != 11) {}
    }
    else
    {
      i = a(localFileManagerEntity.getFilePath());
    }
    if ((i != 3) && (i != 6))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "FileBrowser : File type wrong, return!");
      }
      return false;
    }
    if ((localFileManagerEntity.peerType != 0) && (localFileManagerEntity.peerType != 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "FileBrowser : aio[" + localFileManagerEntity.peerType + "] not buddy or disc, return!");
      }
      return false;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt(str1, 0);
    if (i >= m)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "FileBrowser : more then total return!");
      }
      return false;
    }
    long l2 = localSharedPreferences.getLong(str2, 0L);
    long l1 = MessageCache.a();
    paramLong = l2;
    if (l2 == 0L) {
      paramLong = l1;
    }
    paramLong = l1 - paramLong;
    j = localSharedPreferences.getInt(str3, 0);
    if ((paramLong < 86400000L) && (j >= k))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "FileBrowser : OneDay is already show max times return!");
      }
      return false;
    }
    if (PackageUtil.a(paramQQAppInterface.getApp().getBaseContext(), "com.tencent.tim"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "FileBrowser : Tim installed return!");
      }
      return false;
    }
    localEditor.putLong(str2, l1);
    localEditor.putInt(str1, i + 1);
    if (paramLong >= 86400000L) {
      localEditor.putInt(str3, 1);
    }
    for (;;)
    {
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "FileBrowser : lastShowTime[" + l1 + "],[" + e(localFileManagerEntity.peerUin) + "]add new FileBrowserTimTips!");
      }
      FileManagerReporter.a("0X8008468");
      return true;
      localEditor.putInt(str3, j + 1);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return a(paramQQAppInterface, paramChatMessage, paramContext, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (paramChatMessage == null) {
      return false;
    }
    if (!(paramChatMessage instanceof MessageForFile)) {
      return false;
    }
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = a(paramQQAppInterface, localMessageForFile);
    switch (localFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      return false;
    case 1: 
      if (paramChatMessage.isSend()) {}
      for (paramChatMessage = paramQQAppInterface.getCurrentAccountUin();; paramChatMessage = localMessageForFile.frienduin)
      {
        if (!paramBoolean) {
          FMToastUtil.d(paramContext.getString(2131428195));
        }
        paramQQAppInterface.a().a(localFileManagerEntity, paramChatMessage);
        paramQQAppInterface.a().c(localFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] No reInit,Show Juhua");
        }
        paramChatMessage = new FileManagerReporter.fileAssistantReportData();
        paramChatMessage.jdField_b_of_type_JavaLangString = "file_to_weiyun";
        paramChatMessage.jdField_a_of_type_Int = 9;
        paramChatMessage.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramChatMessage.jdField_c_of_type_JavaLangString = FileUtil.a(localFileManagerEntity.fileName);
        FileManagerReporter.a(paramQQAppInterface.getCurrentAccountUin(), paramChatMessage);
        return true;
      }
    case 2: 
      return false;
    }
    if (!paramBoolean) {
      FMToastUtil.d(paramContext.getString(2131428195));
    }
    ResponseHandler.a();
    paramQQAppInterface.a().a(localFileManagerEntity.getFilePath(), null, paramQQAppInterface.getAccount(), 0, false);
    paramQQAppInterface.a().c(localFileManagerEntity);
    if (QLog.isColorLevel()) {
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] reInit");
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface.getApplication().getBaseContext(), paramIFileViewerAdapter.a(), "PreviewMode");
    int j = -1;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.length() > 0) {
        i = j;
      }
    }
    do
    {
      try
      {
        j = Integer.parseInt(paramQQAppInterface);
        i = j;
        int k = paramIFileViewerAdapter.d();
        i = j;
        if (k == 16)
        {
          bool = false;
          return bool;
        }
      }
      catch (NumberFormatException paramQQAppInterface) {}
      boolean bool = a(i);
    } while (NetworkUtil.d(BaseApplicationImpl.getContext()));
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (FMConfig.b() == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "FileBrowser : TimFaSwitch is off,return!");
      }
    }
    do
    {
      return false;
      if (!PackageUtil.a(paramQQAppInterface.getApp().getBaseContext(), "com.tencent.tim")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return false!");
    return false;
    FileManagerReporter.a("0X800847B");
    return true;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l2 = 604800000L;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    long l1 = l2;
    switch (paramFileManagerEntity.peerType)
    {
    }
    for (l1 = l2; l1 + l3 <= MessageCache.a() * 1000L; l1 = 2592000000L) {
      return true;
    }
    return false;
  }
  
  public static boolean a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.c();
    int j = paramIFileViewerAdapter.d();
    String str = paramIFileViewerAdapter.c();
    paramIFileViewerAdapter = paramIFileViewerAdapter.e();
    return (i == 3) && (j == 1) && ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramIFileViewerAdapter)));
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  public static boolean a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    for (long l = 0L; paramArrayList.hasNext(); l += l) {
      if (FileModel.a((FileManagerEntity)paramArrayList.next()).a(paramBoolean)) {
        return true;
      }
    }
    return l > FMConfig.a();
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().m(paramString);
    case 127: 
      return paramQQAppInterface.a().k(paramString);
    case 102: 
      return paramQQAppInterface.a().f(paramString);
    case 118: 
      return paramQQAppInterface.a().o(paramString);
    case 109: 
      return paramQQAppInterface.a().q(paramString);
    }
    return paramQQAppInterface.a().d(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 2959	java/io/BufferedInputStream
    //   5: dup
    //   6: new 2961	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 2962	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 2965	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: ldc_w 2967
    //   28: invokestatic 2972	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   31: astore_2
    //   32: aload_0
    //   33: aload 4
    //   35: invokevirtual 2491	java/io/InputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +39 -> 79
    //   43: aload_2
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 2975	java/security/MessageDigest:update	([BII)V
    //   51: goto -19 -> 32
    //   54: astore_2
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 2499	java/io/InputStream:close	()V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 2976	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: aconst_null
    //   75: astore_2
    //   76: goto -44 -> 32
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 2499	java/io/InputStream:close	()V
    //   87: aload_2
    //   88: ifnull +25 -> 113
    //   91: aload_2
    //   92: invokevirtual 2979	java/security/MessageDigest:digest	()[B
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload_0
    //   101: ifnull -34 -> 67
    //   104: aload_0
    //   105: invokevirtual 2499	java/io/InputStream:close	()V
    //   108: aload_3
    //   109: areturn
    //   110: astore_0
    //   111: aload_3
    //   112: areturn
    //   113: aload_3
    //   114: astore_2
    //   115: aload_0
    //   116: ifnull -49 -> 67
    //   119: aload_0
    //   120: invokevirtual 2499	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_3
    //   132: astore_2
    //   133: aload_0
    //   134: ifnull -67 -> 67
    //   137: aload_0
    //   138: invokevirtual 2499	java/io/InputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: areturn
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 2499	java/io/InputStream:close	()V
    //   157: aload_2
    //   158: athrow
    //   159: astore 4
    //   161: goto -74 -> 87
    //   164: astore_0
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: goto -11 -> 157
    //   171: astore_2
    //   172: goto -23 -> 149
    //   175: astore_2
    //   176: goto -45 -> 131
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -127 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   38	10	1	i	int
    //   31	13	2	localMessageDigest	java.security.MessageDigest
    //   54	1	2	localFileNotFoundException	FileNotFoundException
    //   56	12	2	localObject1	Object
    //   69	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   75	58	2	localObject2	Object
    //   146	12	2	localObject3	Object
    //   171	1	2	localObject4	Object
    //   175	1	2	localIOException1	IOException
    //   1	131	3	localObject5	Object
    //   23	22	4	arrayOfByte	byte[]
    //   159	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   18	25	54	java/io/FileNotFoundException
    //   25	32	54	java/io/FileNotFoundException
    //   32	39	54	java/io/FileNotFoundException
    //   43	51	54	java/io/FileNotFoundException
    //   70	74	54	java/io/FileNotFoundException
    //   83	87	54	java/io/FileNotFoundException
    //   91	96	54	java/io/FileNotFoundException
    //   25	32	69	java/security/NoSuchAlgorithmException
    //   104	108	110	java/io/IOException
    //   119	123	125	java/io/IOException
    //   2	18	128	java/io/IOException
    //   137	141	143	java/io/IOException
    //   2	18	146	finally
    //   83	87	159	java/io/IOException
    //   61	65	164	java/io/IOException
    //   153	157	167	java/io/IOException
    //   18	25	171	finally
    //   25	32	171	finally
    //   32	39	171	finally
    //   43	51	171	finally
    //   70	74	171	finally
    //   83	87	171	finally
    //   91	96	171	finally
    //   18	25	175	java/io/IOException
    //   25	32	175	java/io/IOException
    //   32	39	175	java/io/IOException
    //   43	51	175	java/io/IOException
    //   70	74	175	java/io/IOException
    //   91	96	175	java/io/IOException
    //   2	18	179	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 2961	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 2962	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 2981
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 2987	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 2988	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 2981
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   58: ldc_w 378
    //   61: iconst_1
    //   62: new 154	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 2990
    //   72: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 2991	java/io/IOException:toString	()Ljava/lang/String;
    //   79: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore 5
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: astore_3
    //   96: ldc_w 378
    //   99: iconst_1
    //   100: new 154	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 2993
    //   110: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 2991	java/io/IOException:toString	()Ljava/lang/String;
    //   118: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 6
    //   129: astore_3
    //   130: aload_0
    //   131: ifnull -87 -> 44
    //   134: aload_0
    //   135: invokevirtual 2988	java/io/FileInputStream:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   145: ldc_w 378
    //   148: iconst_1
    //   149: new 154	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 2990
    //   159: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 2991	java/io/IOException:toString	()Ljava/lang/String;
    //   166: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 2988	java/io/FileInputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   195: ldc_w 378
    //   198: iconst_1
    //   199: new 154	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 2990
    //   209: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_3
    //   213: invokevirtual 2991	java/io/IOException:toString	()Ljava/lang/String;
    //   216: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: goto -37 -> 188
    //   228: astore_0
    //   229: goto -49 -> 180
    //   232: astore 5
    //   234: aload 4
    //   236: astore_0
    //   237: goto -143 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	23	3	localIOException1	IOException
    //   95	90	3	localObject2	Object
    //   190	23	3	localIOException2	IOException
    //   11	224	4	localFileInputStream	java.io.FileInputStream
    //   90	24	5	localIOException3	IOException
    //   232	1	5	localIOException4	IOException
    //   1	127	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	90	java/io/IOException
    //   134	138	140	java/io/IOException
    //   3	13	177	finally
    //   184	188	190	java/io/IOException
    //   24	30	228	finally
    //   96	127	228	finally
    //   24	30	232	java/io/IOException
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static int b(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null) {
      return 2130841697;
    }
    return a(a(paramString));
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  private static Bitmap b(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((j < 0) || (i < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        j = Math.max(0, j / 2);
        i = Math.max(0, i / 2);
        localObject2 = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
        i = (paramInt1 - ((Rect)localObject2).width()) / 2;
        j = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
        return localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label225:
        if (paramMatrix == null) {
          break label378;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          if (paramMatrix != paramBitmap) {
            paramBitmap.recycle();
          }
          i = Math.max(0, paramMatrix.getWidth() - paramInt1);
          j = Math.max(0, paramMatrix.getHeight() - paramInt2);
        }
        catch (OutOfMemoryError paramMatrix)
        {
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
          return null;
        }
        try
        {
          localObject2 = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
          localObject1 = localObject2;
          if (localObject2 == paramMatrix) {
            break;
          }
          localObject1 = localObject2;
          if (paramMatrix == paramBitmap) {
            break;
          }
          paramMatrix.recycle();
          return localObject2;
        }
        catch (OutOfMemoryError paramMatrix)
        {
          label378:
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        }
      }
      paramMatrix = null;
      break label225;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label225;
      }
      paramMatrix = null;
      break label225;
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static IForwardCallBack b(QQAppInterface paramQQAppInterface)
  {
    return new adps(paramQQAppInterface);
  }
  
  public static String b()
  {
    return FMSettings.a().b();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 0: 
      return "image";
    case 1: 
      return "audio";
    case 2: 
      return "video";
    case 3: 
      return "doc";
    case 4: 
      return "zip";
    case 5: 
      return "apk";
    case 6: 
      return "excel";
    case 7: 
      return "ppt";
    case 8: 
      return "html";
    case 9: 
      return "pdf";
    case 10: 
      return "txt";
    }
    return "psd";
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject6 = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject1;
    label274:
    Object localObject2;
    label283:
    Object localObject5;
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.getCloudType() == 0) {
        localObject1 = localBaseApplication.getString(2131428135);
      }
      if (paramFileManagerEntity.getCloudType() != 5) {
        break label1108;
      }
      if (paramFileManagerEntity.bSend)
      {
        localObject1 = localBaseApplication.getString(2131428137);
        localObject4 = paramFileManagerEntity.peerNick;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject2 == null) || (((String)localObject2).equals(localBaseApplication.getString(2131428125))) || (((String)localObject2).equals(localBaseApplication.getString(2131428136)))) {
          break label1102;
        }
        localObject5 = paramFileManagerEntity.peerNick;
        label323:
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = localBaseApplication.getString(2131428137);
          }
        }
        localObject4 = localObject5;
      }
      break;
    }
    try
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject4 = localObject5;
      localObject2 = a(localQQAppInterface, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
    }
    catch (Exception localException1)
    {
      label430:
      label467:
      label469:
      do
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          localObject3 = localObject4;
        }
        if ((localObject1 != null) && (localObject3 != null)) {
          return (String)localObject1 + " " + localObject3;
        }
        paramFileManagerEntity = (FileManagerEntity)localObject1;
      } while (localObject1 != null);
      return localObject3;
    }
    try
    {
      if (paramFileManagerEntity.TroopUin == 0L) {
        break label1099;
      }
      localObject4 = ((TroopManager)localQQAppInterface.getManager(51)).a(String.valueOf(paramFileManagerEntity.TroopUin));
      if ((localObject4 != null) && (((TroopInfo)localObject4).getTroopName() != null)) {
        break label875;
      }
      localObject2 = "";
      localObject4 = localObject2;
      if (!paramFileManagerEntity.bSend) {
        break label918;
      }
      localObject4 = localObject2;
      localObject2 = localBaseApplication.getString(2131428287) + (String)localObject2;
      localObject1 = null;
    }
    catch (Exception localException2)
    {
      break label1040;
      break label469;
    }
    Object localObject4 = localObject2;
    if (localObject1 != null) {
      localObject4 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (((String)localObject1).equals(localBaseApplication.getString(2131428125))) {
          localObject4 = null;
        }
        localObject2 = localObject4;
        if (paramFileManagerEntity.peerType != 3000) {
          continue;
        }
        if (localObject1 != null)
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localBaseApplication.getString(2131428125))) {}
        }
        else
        {
          localObject2 = localObject4;
          if (paramFileManagerEntity.nOpType != 28) {
            continue;
          }
        }
        localObject2 = localObject4;
        localObject5 = ((DiscussionManager)localQQAppInterface.getManager(52)).a(String.valueOf(paramFileManagerEntity.peerUin));
        if (localObject5 == null) {
          break label1115;
        }
        localObject2 = localObject4;
        if (((DiscussionInfo)localObject5).discussionName != null) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        label875:
        continue;
        label918:
        localObject3 = localObject1;
        label1040:
        localObject1 = localException3;
        continue;
      }
      localObject2 = localObject4;
      if (paramFileManagerEntity.bSend)
      {
        localObject2 = localObject4;
        localObject4 = localBaseApplication.getString(2131428288) + (String)localObject4;
        localObject1 = localObject4;
        localObject2 = localObject6;
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(localBaseApplication.getString(2131428136))) || (!paramFileManagerEntity.bSend)) {
          continue;
        }
        paramFileManagerEntity = localBaseApplication.getString(2131428137) + " " + (String)localObject2;
        return paramFileManagerEntity;
        localObject1 = localBaseApplication.getString(2131428135);
        break;
        localObject1 = localBaseApplication.getString(2131428125);
        break;
        localObject1 = localBaseApplication.getString(2131428137);
        break;
        localObject1 = localBaseApplication.getString(2131428136);
        break;
        if (paramFileManagerEntity.bSend)
        {
          localObject1 = localBaseApplication.getString(2131428137);
          break;
        }
        localObject1 = localBaseApplication.getString(2131428135);
        break;
        localObject1 = localBaseApplication.getString(2131428269);
        break;
        localObject1 = localBaseApplication.getString(2131428270);
        break;
        localObject1 = localBaseApplication.getString(2131428271);
        break;
        localObject1 = localBaseApplication.getString(2131428272);
        break;
        localObject1 = localBaseApplication.getString(2131428273);
        break;
        localObject1 = localBaseApplication.getString(2131428274);
        break;
        localObject1 = localBaseApplication.getString(2131428275);
        break;
        localObject1 = localBaseApplication.getString(2131428276);
        break;
        localObject1 = localBaseApplication.getString(2131428135);
        break label274;
        if ((localObject4 != null) && (((TroopInfo)localObject4).getTroopName() != null) && (((TroopInfo)localObject4).getTroopName().length() > 14))
        {
          localObject4 = ((TroopInfo)localObject4).getTroopName();
          localObject2 = localObject4;
          break label430;
        }
        localObject4 = ((TroopInfo)localObject4).getTroopName();
        localObject2 = localObject4;
        break label430;
        localObject4 = localObject2;
        localObject2 = localBaseApplication.getString(2131428286) + (String)localObject2;
        break label467;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          if (((DiscussionInfo)localObject5).discussionName != null)
          {
            localObject2 = localObject4;
            if (((DiscussionInfo)localObject5).discussionName.length() > 14)
            {
              localObject2 = localObject4;
              localObject4 = ((DiscussionInfo)localObject5).discussionName;
              continue;
            }
          }
        }
        localObject2 = localObject4;
        localObject4 = ((DiscussionInfo)localObject5).discussionName;
        continue;
      }
      localObject2 = localObject4;
      localObject4 = localBaseApplication.getString(2131428289) + (String)localObject4;
      localObject1 = localObject4;
      localObject2 = localObject6;
      continue;
      label1099:
      label1102:
      localObject5 = localObject1;
      break label323;
      label1108:
      Object localObject3 = localObject1;
      localObject1 = null;
      break label283;
      label1115:
      String str = "";
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label160;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      File localFile = new File(paramString);
      i = 1;
      str2 = paramString;
      paramString = localFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new File(str2);
        i += 1;
      }
      label160:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
  
  public static void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = localQQAppInterface.a().a();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.status = 16;
        localQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.bSend);
      }
    }
    localQQAppInterface.a().f();
  }
  
  /* Error */
  public static void b(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 3122	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 25	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 27	java/util/ArrayList:<init>	()V
    //   16: putstatic 3122	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: getstatic 3122	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 1290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 3124	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 3122	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 1290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 1619	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 658
    //   58: iconst_2
    //   59: new 154	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 3126
    //   69: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 750	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 3128
    //   82: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -57 -> 34
    //   94: astore_3
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramLong	long
    //   29	2	2	bool	boolean
    //   94	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	94	finally
    //   19	30	94	finally
    //   38	91	94	finally
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      FMToastUtil.a(2131428188);
      return;
    }
    FileManagerReporter.a("0X8007152");
    QbSdk.openFileReaderListWithQBDownload(paramActivity, paramString, new adqb(new WeakReference(paramActivity), paramActivity));
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 3, paramString1);
  }
  
  public static void b(Context paramContext)
  {
    paramContext.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
  }
  
  @RequiresApi(api=26)
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ShortcutManager localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
    if ((localShortcutManager != null) && (localShortcutManager.isRequestPinShortcutSupported()))
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.putExtra(paramString1, true);
      localIntent.setClassName(paramContext, JumpActivity.class.getName());
      localIntent.setFlags(337641472);
      localShortcutManager.requestPinShortcut(new ShortcutInfo.Builder(paramContext, "my-shortcut").setShortLabel(paramString2).setIcon(Icon.createWithResource(paramContext, paramInt)).setIntent(localIntent).build(), PendingIntent.getBroadcast(paramContext, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 134217728).getIntentSender());
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.strSrcName == null) {
      paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
    }
    while (paramFileManagerEntity.strSrcName.length() != 0) {
      return;
    }
    paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
  }
  
  public static void b(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    if (paramFileManagerEntity.nFileType == 0)
    {
      String str2 = paramFileManagerEntity.strLargeThumPath;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = c(paramFileManagerEntity);
      }
      if (FileUtils.b(str1))
      {
        paramFileManagerEntity.strLargeThumPath = str1;
        paramAsyncImageView.setDefaultImage(2130841666);
        paramAsyncImageView.setAsyncImage(str1);
        return;
      }
    }
    a(paramAsyncImageView, paramFileManagerEntity.fileName);
  }
  
  public static void b(String paramString)
  {
    try
    {
      BaseApplicationImpl.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter)
  {
    boolean bool = true;
    FileManagerEntity localFileManagerEntity = paramIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return false;
    }
    int i;
    int j;
    label61:
    int k;
    label98:
    int m;
    label110:
    int n;
    if ((a(paramQQAppInterface, paramIFileViewerAdapter)) && (!localFileManagerEntity.isZipInnerFile))
    {
      i = 1;
      if ((paramIFileViewerAdapter.b() == 6000) || (paramIFileViewerAdapter.c() == 7)) {
        break label154;
      }
      j = 1;
      if ((paramIFileViewerAdapter.c() == 3) && (localFileManagerEntity.strTroopFilePath == null) && (localFileManagerEntity.Uuid == null) && (localFileManagerEntity.WeiYunFileId == null)) {
        break label159;
      }
      k = 1;
      if (paramIFileViewerAdapter.c() == 0) {
        break label165;
      }
      m = 1;
      if (paramIFileViewerAdapter.c() == 5) {
        break label171;
      }
      n = 1;
      label123:
      if ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (n == 0)) {
        break label177;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label154:
      j = 0;
      break label61;
      label159:
      k = 0;
      break label98;
      label165:
      m = 0;
      break label110;
      label171:
      n = 0;
      break label123;
      label177:
      bool = false;
    }
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return !FileUtil.a(paramFileManagerEntity.getFilePath()).equalsIgnoreCase(".mov");
  }
  
  public static boolean b(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.c();
    int j = paramIFileViewerAdapter.d();
    return (i == 3) && (j == 1);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: ldc_w 2967
    //   3: invokestatic 2972	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +32 -> 42
    //   13: aconst_null
    //   14: astore_0
    //   15: iconst_0
    //   16: ifeq +11 -> 27
    //   19: new 3234	java/lang/NullPointerException
    //   22: dup
    //   23: invokespecial 3235	java/lang/NullPointerException:<init>	()V
    //   26: athrow
    //   27: aload_0
    //   28: areturn
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 2976	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   36: aconst_null
    //   37: astore 5
    //   39: goto -31 -> 8
    //   42: new 2959	java/io/BufferedInputStream
    //   45: dup
    //   46: new 2961	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 2962	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 2965	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 4
    //   59: sipush 10240
    //   62: newarray byte
    //   64: astore 6
    //   66: iconst_0
    //   67: istore_1
    //   68: aload_0
    //   69: invokestatic 3237	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)J
    //   72: lstore_2
    //   73: iload_1
    //   74: sipush 1024
    //   77: if_icmpge +25 -> 102
    //   80: aload 5
    //   82: aload 6
    //   84: iconst_0
    //   85: aload 4
    //   87: aload 6
    //   89: invokevirtual 2491	java/io/InputStream:read	([B)I
    //   92: invokevirtual 2975	java/security/MessageDigest:update	([BII)V
    //   95: iload_1
    //   96: iconst_1
    //   97: iadd
    //   98: istore_1
    //   99: goto -26 -> 73
    //   102: aload 4
    //   104: lload_2
    //   105: ldc2_w 935
    //   108: ldiv
    //   109: ldc2_w 3238
    //   112: lsub
    //   113: ldc2_w 3240
    //   116: lsub
    //   117: invokevirtual 3244	java/io/InputStream:skip	(J)J
    //   120: pop2
    //   121: iconst_0
    //   122: istore_1
    //   123: iload_1
    //   124: sipush 1024
    //   127: if_icmpge +25 -> 152
    //   130: aload 5
    //   132: aload 6
    //   134: iconst_0
    //   135: aload 4
    //   137: aload 6
    //   139: invokevirtual 2491	java/io/InputStream:read	([B)I
    //   142: invokevirtual 2975	java/security/MessageDigest:update	([BII)V
    //   145: iload_1
    //   146: iconst_1
    //   147: iadd
    //   148: istore_1
    //   149: goto -26 -> 123
    //   152: aload 4
    //   154: lload_2
    //   155: ldc2_w 935
    //   158: ldiv
    //   159: ldc2_w 3245
    //   162: lsub
    //   163: lconst_1
    //   164: ladd
    //   165: invokevirtual 3244	java/io/InputStream:skip	(J)J
    //   168: pop2
    //   169: iconst_0
    //   170: istore_1
    //   171: iload_1
    //   172: sipush 1024
    //   175: if_icmpge +25 -> 200
    //   178: aload 5
    //   180: aload 6
    //   182: iconst_0
    //   183: aload 4
    //   185: aload 6
    //   187: invokevirtual 2491	java/io/InputStream:read	([B)I
    //   190: invokevirtual 2975	java/security/MessageDigest:update	([BII)V
    //   193: iload_1
    //   194: iconst_1
    //   195: iadd
    //   196: istore_1
    //   197: goto -26 -> 171
    //   200: bipush 8
    //   202: newarray byte
    //   204: astore_0
    //   205: iconst_0
    //   206: istore_1
    //   207: goto +152 -> 359
    //   210: aload 5
    //   212: aload_0
    //   213: iconst_0
    //   214: bipush 8
    //   216: invokevirtual 2975	java/security/MessageDigest:update	([BII)V
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 2499	java/io/InputStream:close	()V
    //   229: aload 5
    //   231: ifnull +30 -> 261
    //   234: aload 5
    //   236: invokevirtual 2979	java/security/MessageDigest:digest	()[B
    //   239: astore 5
    //   241: aload 5
    //   243: astore_0
    //   244: aload 4
    //   246: ifnull -219 -> 27
    //   249: aload 4
    //   251: invokevirtual 2499	java/io/InputStream:close	()V
    //   254: aload 5
    //   256: areturn
    //   257: astore_0
    //   258: aload 5
    //   260: areturn
    //   261: aconst_null
    //   262: astore_0
    //   263: aload 4
    //   265: ifnull -238 -> 27
    //   268: aload 4
    //   270: invokevirtual 2499	java/io/InputStream:close	()V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_0
    //   276: aconst_null
    //   277: areturn
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_0
    //   281: aload_0
    //   282: ifnull +7 -> 289
    //   285: aload_0
    //   286: invokevirtual 2499	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: astore_0
    //   292: aconst_null
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull -8 -> 289
    //   300: aload 4
    //   302: invokevirtual 2499	java/io/InputStream:close	()V
    //   305: goto -16 -> 289
    //   308: astore_0
    //   309: goto -20 -> 289
    //   312: astore_0
    //   313: aconst_null
    //   314: astore 4
    //   316: aload 4
    //   318: ifnull +8 -> 326
    //   321: aload 4
    //   323: invokevirtual 2499	java/io/InputStream:close	()V
    //   326: aload_0
    //   327: athrow
    //   328: astore_0
    //   329: aconst_null
    //   330: areturn
    //   331: astore_0
    //   332: goto -103 -> 229
    //   335: astore_0
    //   336: goto -47 -> 289
    //   339: astore 4
    //   341: goto -15 -> 326
    //   344: astore_0
    //   345: goto -29 -> 316
    //   348: astore_0
    //   349: goto -54 -> 295
    //   352: astore_0
    //   353: aload 4
    //   355: astore_0
    //   356: goto -75 -> 281
    //   359: iload_1
    //   360: bipush 8
    //   362: if_icmpge -152 -> 210
    //   365: aload_0
    //   366: bipush 8
    //   368: iload_1
    //   369: isub
    //   370: iconst_1
    //   371: isub
    //   372: lload_2
    //   373: bipush 64
    //   375: iload_1
    //   376: iconst_1
    //   377: iadd
    //   378: bipush 8
    //   380: imul
    //   381: isub
    //   382: lshr
    //   383: ldc2_w 3247
    //   386: land
    //   387: l2i
    //   388: i2b
    //   389: bastore
    //   390: iload_1
    //   391: iconst_1
    //   392: iadd
    //   393: istore_1
    //   394: goto -35 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramString	String
    //   67	327	1	i	int
    //   72	301	2	l	long
    //   29	3	4	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   57	265	4	localBufferedInputStream	java.io.BufferedInputStream
    //   339	15	4	localIOException	IOException
    //   6	253	5	localObject	Object
    //   64	122	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	8	29	java/security/NoSuchAlgorithmException
    //   249	254	257	java/io/IOException
    //   268	273	275	java/io/IOException
    //   0	8	278	java/io/FileNotFoundException
    //   31	36	278	java/io/FileNotFoundException
    //   42	59	278	java/io/FileNotFoundException
    //   0	8	291	java/io/IOException
    //   31	36	291	java/io/IOException
    //   42	59	291	java/io/IOException
    //   300	305	308	java/io/IOException
    //   0	8	312	finally
    //   31	36	312	finally
    //   42	59	312	finally
    //   19	27	328	java/io/IOException
    //   224	229	331	java/io/IOException
    //   285	289	335	java/io/IOException
    //   321	326	339	java/io/IOException
    //   59	66	344	finally
    //   68	73	344	finally
    //   80	95	344	finally
    //   102	121	344	finally
    //   130	145	344	finally
    //   152	169	344	finally
    //   178	193	344	finally
    //   200	205	344	finally
    //   210	219	344	finally
    //   224	229	344	finally
    //   234	241	344	finally
    //   59	66	348	java/io/IOException
    //   68	73	348	java/io/IOException
    //   80	95	348	java/io/IOException
    //   102	121	348	java/io/IOException
    //   130	145	348	java/io/IOException
    //   152	169	348	java/io/IOException
    //   178	193	348	java/io/IOException
    //   200	205	348	java/io/IOException
    //   210	219	348	java/io/IOException
    //   234	241	348	java/io/IOException
    //   59	66	352	java/io/FileNotFoundException
    //   68	73	352	java/io/FileNotFoundException
    //   80	95	352	java/io/FileNotFoundException
    //   102	121	352	java/io/FileNotFoundException
    //   130	145	352	java/io/FileNotFoundException
    //   152	169	352	java/io/FileNotFoundException
    //   178	193	352	java/io/FileNotFoundException
    //   200	205	352	java/io/FileNotFoundException
    //   210	219	352	java/io/FileNotFoundException
    //   224	229	352	java/io/FileNotFoundException
    //   234	241	352	java/io/FileNotFoundException
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  @TargetApi(9)
  public static int c(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.nFileType == 0))
    {
      String str = paramFileManagerEntity.zipInnerPath;
      paramFileManagerEntity = (String)paramFileManagerEntity.mContext;
      paramFileManagerEntity = MD5.a(paramFileManagerEntity + str);
      return FMSettings.a().d() + "x-zip-" + paramFileManagerEntity;
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileType", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileType", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileType", "7");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileType", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptPreviewMode", "4");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileType", "6");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxPreviewMode", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileType", "8");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfPreviewMode", "3");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileType", "13");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileType", "14");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileType", "15");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileType", "16");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtPreviewMode", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFlowSize", "1024");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFlowTime", "30");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFtnThumbMaxSize", "32768");
    }
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  /* Error */
  public static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 3122	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 3122	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: lload_0
    //   19: invokestatic 1290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 3414	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 658
    //   35: iconst_2
    //   36: new 154	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 3126
    //   46: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokestatic 750	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 3416
    //   59: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: goto -57 -> 11
    //   71: astore_2
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramLong	long
    //   6	2	2	localArrayList	ArrayList
    //   71	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   15	68	71	finally
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      FMToastUtil.a(2131428188);
      return;
    }
    String str = MimeTypesTools.a(paramActivity, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), str);
    paramString = paramActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
    if ((paramString.size() == 1) && (((ResolveInfo)paramString.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int i = 1;; i = 0)
    {
      if ((paramString.size() > 0) && (i == 0)) {
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity)
        {
          FMToastUtil.a(2131427527);
          return;
        }
      }
      FMToastUtil.a(2131427527);
      return;
    }
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    boolean bool;
    do
    {
      return;
      bool = FileUtil.a(paramFileManagerEntity.getFilePath());
      if ((bool) && ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 16) || (paramFileManagerEntity.nOpType == 14) || (paramFileManagerEntity.nOpType == 15) || (paramFileManagerEntity.nOpType == 17) || (paramFileManagerEntity.nOpType == 18) || (paramFileManagerEntity.nOpType == 19) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 5) || (paramFileManagerEntity.nOpType == -1)))
      {
        paramFileManagerEntity.cloudType = 3;
        paramFileManagerEntity.status = 1;
        return;
      }
    } while ((paramFileManagerEntity.getCloudType() != 3) || ((bool) && ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 6))));
    if (paramFileManagerEntity.nFileType == 5) {
      FileCategoryUtil.a(paramFileManagerEntity);
    }
    if (paramFileManagerEntity.status == 1)
    {
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
      if ((paramFileManagerEntity.WeiYunFileId != null) && (paramFileManagerEntity.WeiYunFileId.length() > 0))
      {
        paramFileManagerEntity.setCloudType(2);
        paramFileManagerEntity.status = -1;
        return;
      }
      paramFileManagerEntity.status = 16;
      return;
    }
    paramFileManagerEntity.status = 16;
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {}
    do
    {
      do
      {
        return false;
      } while (paramFileManagerEntity.isZipInnerFile);
      switch (a(paramFileManagerEntity))
      {
      case 5: 
      default: 
        return false;
      case 1: 
      case 2: 
      case 4: 
        return true;
      }
    } while (paramFileManagerEntity.nFileType != 0);
    return true;
    if (paramFileManagerEntity.nFileType == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(String paramString)
  {
    return FileUtil.b(paramString);
  }
  
  public static byte[] c(String paramString)
  {
    return a(paramString, a(paramString));
  }
  
  public static int d(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static String d(String paramString)
  {
    int i = 3;
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    boolean bool = a(paramString);
    if (FontSettingManager.a() >= 20.0F) {
      if (bool) {
        i = 7;
      }
    }
    for (;;)
    {
      str = paramString;
      if (paramString.length() <= 16 - i) {
        break;
      }
      int j = paramString.length();
      str = paramString.substring(0, (16 - i) / 2);
      paramString = paramString.substring(j - (16 - i) / 2);
      return str + "..." + paramString;
      if (FontSettingManager.a() >= 18.0F)
      {
        if (bool) {
          i = 5;
        } else {
          i = 2;
        }
      }
      else if (FontSettingManager.a() >= 17.0F)
      {
        if (!bool) {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
  }
  
  public static void d(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramActivity.getString(2131435124));
    UniformDownloadMgr.a().a(paramString, localBundle);
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity.nFileType == 0) {
      if (FileUtils.b(paramFileManagerEntity.getFilePath()))
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        FilePicURLDrawlableHelper.a(paramFileManagerEntity.getFilePath(), (BitmapFactory.Options)localObject);
        if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
          break label185;
        }
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outHeight;
        int i = URLDrawableHelper.a(paramFileManagerEntity.getFilePath());
        if ((i == 90) || (i == 270))
        {
          paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outHeight;
          paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outWidth;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "localPic[" + paramFileManagerEntity.nSessionId + "] get thumbsize success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    label185:
    do
    {
      do
      {
        for (;;)
        {
          paramFileManagerEntity = FilePicURLDrawlableHelper.a(paramFileManagerEntity);
          if (paramFileManagerEntity != null) {
            URLDrawableHelper.a(paramFileManagerEntity).downloadImediatly();
          }
          return;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
          }
        }
      } while (paramFileManagerEntity.nFileType != 2);
      localObject = a(paramFileManagerEntity.getFilePath());
    } while (((FileManagerUtil.VideoThumbInfo)localObject).jdField_a_of_type_Int == -1);
    paramFileManagerEntity.strLargeThumPath = ((FileManagerUtil.VideoThumbInfo)localObject).jdField_a_of_type_JavaLangString;
    if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "localvideo[" + paramFileManagerEntity.nSessionId + "] create thumb success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      return;
      paramFileManagerEntity.imgWidth = ((FileManagerUtil.VideoThumbInfo)localObject).jdField_b_of_type_Int;
      paramFileManagerEntity.imgHeight = ((FileManagerUtil.VideoThumbInfo)localObject).jdField_c_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "]get local video,(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.TroopUin == 0L) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))) {
      return false;
    }
    return true;
  }
  
  public static int e(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static String e(String paramString)
  {
    int i = 0;
    String str;
    if (paramString == null)
    {
      str = "";
      return str;
    }
    label180:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int j = 0;
          if (j < paramString.length())
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label180;
            }
            i %= "AnDrDQ_Fm_String".length();
            int m = paramString.codePointAt(j) + "AnDrDQ_Fm_String".codePointAt(i);
            int k = m;
            if (m > 65535) {
              k = m % 65535;
            }
            localByteArrayBuffer.append(k);
            j += 1;
            i += 1;
            continue;
          }
        }
        paramString = com.qq.taf.jce.HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static void e(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    int i;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        if (paramFileManagerEntity == null)
        {
          localStringBuilder.append("entity is nll,stack:" + a());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        i = paramFileManagerEntity.nFileType;
        if ((i != 2) && (i != 0))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is not pic or video, return");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          continue;
        }
        if (paramFileManagerEntity.imgHeight <= 0) {
          break;
        }
      }
      finally {}
      if (paramFileManagerEntity.imgWidth <= 0) {
        break;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("] OK, return!");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    Object localObject1 = paramFileManagerEntity.getFilePath();
    if (FileUtil.b((String)localObject1))
    {
      if (i == 2) {
        bool1 = false;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is local, use local calc size!");
    }
    Object localObject2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label426;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
      QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      localObject1 = paramFileManagerEntity.strLargeThumPath;
      if (FileUtil.b((String)localObject1))
      {
        localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloude , use largThumb calc size!");
        bool1 = bool2;
      }
      else
      {
        localObject1 = paramFileManagerEntity.strMiddleThumPath;
        if (FileUtil.b((String)localObject1))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (i == 2)
          {
            localObject2 = paramFileManagerEntity.strThumbPath;
            bool1 = bool2;
            localObject1 = localObject2;
            if (FileUtil.b((String)localObject2))
            {
              localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] video is cloud , use thumb calc size!");
              bool1 = bool2;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label426:
    if (bool1)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
      i = URLDrawableHelper.a((String)localObject1);
      if ((i == 90) || (i == 270))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outHeight;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outWidth;
      }
    }
    for (;;)
    {
      localStringBuilder.append(" calc size over size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("]");
      localStringBuilder.append(" useImageCreateThumb:").append(bool1);
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      if (i == 2) {
        d(paramFileManagerEntity);
      } else {
        localStringBuilder.append("!!!!!!!!FILETYPE ERROR!!!!!!!");
      }
    }
  }
  
  public static boolean e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (FileUtil.b(paramFileManagerEntity.strFilePath)) {
      return true;
    }
    if (FileUtil.b(paramFileManagerEntity.strMiddleThumPath)) {
      return true;
    }
    if (FileUtil.b(paramFileManagerEntity.strLargeThumPath)) {
      return true;
    }
    if (FileUtil.b(paramFileManagerEntity.strThumbPath)) {
      return true;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] no Thumb!");
    return false;
  }
  
  public static String f(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > 0) && (i < paramString.length() - 1)) {
      return paramString.substring(i + 1).toUpperCase();
    }
    return "";
  }
  
  public static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("ftn_compress_getfile", "ftn_compress_getabs");
    return paramString + "size=750&";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */