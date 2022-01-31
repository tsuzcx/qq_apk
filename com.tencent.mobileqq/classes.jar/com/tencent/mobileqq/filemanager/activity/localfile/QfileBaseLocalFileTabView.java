package com.tencent.mobileqq.filemanager.activity.localfile;

import alud;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import aqni;
import aqno;
import aqow;
import aqpn;
import aqpo;
import aqpp;
import aqpq;
import aqpu;
import aqpv;
import aqpw;
import aqru;
import aqsb;
import aqwl;
import aqwn;
import arbs;
import arlq;
import arls;
import arlv;
import arri;
import arrp;
import arrq;
import arrr;
import arso;
import arsq;
import arvi;
import azqs;
import bdgm;
import bdgx;
import bdjz;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import zjc;

public abstract class QfileBaseLocalFileTabView
  extends QfileBaseTabView
{
  public static String a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public aqni a;
  private aqru jdField_a_of_type_Aqru = new aqpw(this);
  arsq jdField_a_of_type_Arsq = null;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  protected QfilePinnedHeaderExpandableListView a;
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public BubblePopupWindow a;
  protected ArrayList<FileInfo> a;
  public View.OnClickListener b = new aqpp(this);
  public View.OnClickListener c;
  protected LinkedHashMap<String, List<FileInfo>> c;
  public View.OnClickListener d;
  public List<arvi> d;
  protected boolean f;
  boolean g;
  protected boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QfileBaseLocalFileTabView<FileAssistant>";
  }
  
  public QfileBaseLocalFileTabView(Context paramContext, List<arvi> paramList, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aqpo(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new aqpq(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new aqpu(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new aqpv(this);
    this.jdField_d_of_type_JavaUtilList = paramList;
    this.f = paramBoolean;
    this.jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private boolean a(String paramString, int paramInt)
  {
    paramString = arso.a(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.toLowerCase();
      } while (((paramInt == 0) && (!".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString))) || ((paramInt == 2) && (!".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString))));
      if (paramInt != 3) {
        break;
      }
    } while ((!".doc|.docx|.wps|.pages|".contains(paramString)) && (!".xls|.xlsx|.et|.numbers|".contains(paramString)) && (!".pdf|".contains(paramString)) && (!".ppt|.pptx.|.dps|.keynote|".contains(paramString)));
    do
    {
      do
      {
        return true;
        if ((paramInt == 5) && (!".apk|".contains(paramString))) {
          break;
        }
      } while (paramInt != 11);
      if ((".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString)) || (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString)) || (".doc|.docx|.wps|.pages|".contains(paramString)) || (".xls|.xlsx|.et|.numbers|".contains(paramString)) || (".pdf|".contains(paramString)) || (".ppt|.pptx.|.dps|.keynote|".contains(paramString))) {
        break;
      }
    } while (!".apk|".contains(paramString));
    return false;
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366324));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void v()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692497);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.post(new QfileBaseLocalFileTabView.1(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.b);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  protected abstract aqni a();
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected abstract void a();
  
  public void a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    b(paramFileInfo);
  }
  
  public void a(FileInfo paramFileInfo, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((f()) && (!paramBoolean)) {
      if (arbs.a(paramFileInfo))
      {
        arbs.b(paramFileInfo);
        b(paramFileInfo, false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_d_of_type_Boolean) && (!arso.b(paramFileInfo.c())))
        {
          arri.a(arrr.d(paramFileInfo.d()) + alud.a(2131710018));
          arbs.b(paramFileInfo);
        }
        f();
        t();
        k();
      }
    }
    for (;;)
    {
      a(f());
      do
      {
        return;
        arbs.a(paramFileInfo);
        b(paramFileInfo, true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (arbs.a(arbs.jdField_a_of_type_Int)) || (arbs.b(paramFileInfo))) {
          break;
        }
        paramView = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698506);
        paramView.setPositiveButton(2131720972, new bdgx());
        paramView.show();
        arbs.b(arbs.jdField_a_of_type_Int);
        arrp.a("0X800942D");
        break;
        if (b()) {
          break label228;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label228:
      r();
      FileManagerEntity localFileManagerEntity = arrr.a(paramFileInfo);
      Object localObject1 = new arlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity, 10000);
      if (localFileManagerEntity.nFileType == 0)
      {
        Object localObject2 = new ArrayList();
        if (this.jdField_c_of_type_JavaUtilLinkedHashMap != null)
        {
          Iterator localIterator = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((ArrayList)localObject2).addAll((Collection)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str));
          }
        }
        arbs.a((ArrayList)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("clicked_file_hashcode", paramFileInfo.hashCode());
        ((arlq)localObject1).a((Bundle)localObject2);
      }
      localObject1 = new arls(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arlv)localObject1);
      ((arls)localObject1).a(8);
      if (((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2)) && (paramView != null) && ((paramView.getId() == 2131366301) || (paramView.getId() == 2131367921))) {
        ((arls)localObject1).a(zjc.a(paramView));
      }
      ((arls)localObject1).a();
      paramView = new arrq();
      paramView.b = "file_viewer_in";
      paramView.jdField_a_of_type_Int = 80;
      paramView.c = arso.a(paramFileInfo.d());
      paramView.jdField_a_of_type_Long = paramFileInfo.a();
      arrp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
      arrp.a("0X8004AE5");
    }
  }
  
  public void a(String paramString1, arvi paramarvi, List<String> paramList, int paramInt1, TreeMap<Long, FileInfo> paramTreeMap, int paramInt2, String paramString2)
  {
    if ((this.h) || (paramString1 == null)) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel scanMaxFileInfos bPause[" + this.h + "]");
    }
    do
    {
      Object localObject;
      int i;
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject = new VFSFile(paramString1);
            if (!((VFSFile)localObject).isDirectory()) {
              break;
            }
            if (((VFSFile)localObject).getName().indexOf(".") != 0)
            {
              paramString1 = ((VFSFile)localObject).listFiles();
              if (paramString1 != null)
              {
                int j = paramString1.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramString1[i];
                  if (this.h)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel scanMaxFileInfos bPause[" + this.h + "]");
                    return;
                  }
                  a(((VFSFile)localObject).getAbsolutePath(), paramarvi, paramList, paramInt1, paramTreeMap, paramInt2, paramString2);
                  i += 1;
                }
              }
            }
          }
        } while ((!paramarvi.a()) && (!a(paramString1, paramInt1)));
        localObject = FileInfo.a(paramString1);
      } while (localObject == null);
      if (paramarvi.b()) {
        ((FileInfo)localObject).a();
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        i = paramList.indexOf(paramString2);
        paramInt1 = i;
        if (i < 0)
        {
          paramString1 = paramString2;
          if (!paramString2.endsWith("/")) {
            paramString1 = paramString2 + "/";
          }
          paramList.add(paramString1);
          paramInt1 = paramList.size() - 1;
        }
        if (paramInt1 >= 0) {
          ((FileInfo)localObject).e(paramInt1 + "");
        }
      }
      ((FileInfo)localObject).a(true);
      paramTreeMap.put(Long.valueOf(((FileInfo)localObject).a()), localObject);
    } while (paramTreeMap.size() <= paramInt2);
    paramTreeMap.pollFirstEntry();
  }
  
  protected void a(boolean paramBoolean)
  {
    String str2 = "";
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
      if ((this instanceof QfileLocalFileMediaTabView))
      {
        str1 = "0x8009DAF";
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      if ((this instanceof QfileLocalFilePicTabView))
      {
        str1 = "0x8009DB1";
        break;
      }
      if ((this instanceof QfileLocalFileDocTabView))
      {
        str1 = "0x8009DB3";
        break;
      }
      if ((this instanceof QfileLocalFileAppTabView))
      {
        str1 = "0x8009DB5";
        break;
      }
      str1 = str2;
      if (!(this instanceof QfileLocalFileOtherTabView)) {
        break;
      }
      str1 = "0x8009DB7";
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) && (!paramBoolean)) {
        if ((this instanceof QfileLocalFileMediaTabView)) {
          str1 = "0X8009E49";
        }
      }
      while (!TextUtils.isEmpty(str1))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
        return;
        if ((this instanceof QfileLocalFilePicTabView))
        {
          str1 = "0X8009E46";
        }
        else if ((this instanceof QfileLocalFileDocTabView))
        {
          str1 = "0X8009E44";
        }
        else if ((this instanceof QfileLocalFileAppTabView))
        {
          str1 = "0X8009E4C";
        }
        else
        {
          str1 = str2;
          if ((this instanceof QfileLocalFileOtherTabView))
          {
            str1 = "0X8009E48";
            continue;
            str1 = str2;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
              if ((this instanceof QfileLocalFileMediaTabView))
              {
                str1 = "0X8009E5B";
              }
              else if ((this instanceof QfileLocalFilePicTabView))
              {
                str1 = "0X8009E58";
              }
              else if ((this instanceof QfileLocalFileDocTabView))
              {
                str1 = "0X8009E56";
              }
              else if ((this instanceof QfileLocalFileAppTabView))
              {
                str1 = "0X8009E5E";
              }
              else
              {
                str1 = str2;
                if ((this instanceof QfileLocalFileOtherTabView)) {
                  str1 = "0X8009E5A";
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return false;
    }
    return b(paramFileInfo);
  }
  
  public void b()
  {
    int i = 0;
    a(2131560660);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqru);
    o();
    this.jdField_a_of_type_Aqni = a();
    this.jdField_a_of_type_Aqni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    v();
    if (((this.jdField_a_of_type_Aqni instanceof aqno)) || ((this.jdField_a_of_type_Aqni instanceof aqow)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167140);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Aqni);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((aqno)this.jdField_a_of_type_Aqni).c());
      i = 0;
    }
    while (i < this.jdField_a_of_type_Aqni.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
      i += 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167140);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Aqni);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      while (i < this.jdField_a_of_type_Aqni.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
        i += 1;
      }
    }
    setLoadAllRecord(true);
  }
  
  protected abstract void b(FileInfo paramFileInfo);
  
  protected void b(FileInfo paramFileInfo, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  protected abstract boolean b(FileInfo paramFileInfo);
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 64);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    s();
    if (this.jdField_a_of_type_Aqru != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqru);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_JavaUtilLinkedHashMap == null) {
      return;
    }
    Iterator localIterator = new ArrayList(this.jdField_c_of_type_JavaUtilLinkedHashMap.values()).iterator();
    while (localIterator.hasNext()) {
      arbs.a((List)localIterator.next());
    }
    int j = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(i);
      i += 1;
    }
    t();
    this.jdField_a_of_type_Aqni.notifyDataSetChanged();
  }
  
  public void e()
  {
    Iterator localIterator1 = this.jdField_c_of_type_JavaUtilLinkedHashMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        arbs.b((FileInfo)localIterator2.next());
      }
    }
    t();
    this.jdField_a_of_type_Aqni.notifyDataSetChanged();
  }
  
  public void f()
  {
    if ((this.jdField_c_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.5F);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692506);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqni.notifyDataSetChanged();
      g();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      }
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getHeight());
    }
  }
  
  public void h() {}
  
  public void i()
  {
    a(new QfileBaseLocalFileTabView.8(this));
  }
  
  public void j()
  {
    if (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() > 0) {
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
  }
  
  protected void k()
  {
    if ((this.jdField_c_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(true);
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Arsq != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Arsq);
      return;
    }
    this.jdField_a_of_type_Arsq = new aqpn(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Arsq);
  }
  
  public void n()
  {
    this.h = false;
    if ((this.jdField_c_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() == 0)) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
  }
  
  public void q()
  {
    super.q();
    this.h = true;
  }
  
  public void setLoadAllRecord(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.g = paramBoolean;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    while (this.jdField_a_of_type_Aqni.getGroupCount() <= paramInt1) {
      return;
    }
    a(new QfileBaseLocalFileTabView.9(this, paramInt1, paramInt2));
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_Aqni.getGroupCount() <= paramInt) {
      return;
    }
    a(new QfileBaseLocalFileTabView.10(this, paramInt));
  }
  
  public void setTabType(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
 * JD-Core Version:    0.7.0.1
 */