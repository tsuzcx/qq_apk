import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class dz
  implements View.OnClickListener
{
  dz(dy paramdy) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a();
      Object localObject1 = (ek)paramView.getTag();
      Object localObject3 = ((ek)localObject1).a();
      Object localObject2 = ((DataLineMsgSet)localObject3).getFirstItem();
      if (((DataLineMsgSet)localObject3).isSingle())
      {
        if (-1000 != ((DataLineMsgRecord)localObject2).msgtype)
        {
          FileManagerEntity localFileManagerEntity = auea.a((DataLineMsgRecord)localObject2);
          if (bmeb.a().a(localFileManagerEntity))
          {
            bmeb.a().a(this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity.getFilePath(), true);
          }
          else if ((((DataLineMsgRecord)localObject2).nOpType == 31) || (auea.d(localFileManagerEntity)))
          {
            dy.a(this.a, (DataLineMsgRecord)localObject2);
          }
          else if (((DataLineMsgRecord)localObject2).nOpType == 29)
          {
            dy.b(this.a, (DataLineMsgRecord)localObject2);
          }
          else
          {
            localObject3 = new atyj(this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity);
            ArrayList localArrayList = new ArrayList();
            if (localFileManagerEntity.nFileType == 0)
            {
              Iterator localIterator = dy.a(this.a).iterator();
              label350:
              while (localIterator.hasNext())
              {
                Object localObject4 = (DataLineMsgSet)localIterator.next();
                if (((DataLineMsgSet)localObject4).isSingle())
                {
                  localObject4 = ((DataLineMsgSet)localObject4).values().iterator();
                  for (;;)
                  {
                    if (!((Iterator)localObject4).hasNext()) {
                      break label350;
                    }
                    DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject4).next();
                    int j = auea.a(localDataLineMsgRecord.filename);
                    int i = j;
                    if (j == -1)
                    {
                      i = j;
                      if (localDataLineMsgRecord.msgtype == -2000) {
                        i = 0;
                      }
                    }
                    if (i != localFileManagerEntity.nFileType) {
                      break;
                    }
                    if (localDataLineMsgRecord != localObject2) {
                      localArrayList.add(String.valueOf(auea.a(localDataLineMsgRecord).nSessionId));
                    } else {
                      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
                    }
                  }
                }
              }
              if (localArrayList.size() == 0) {
                localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
              }
              ((atyj)localObject3).a(localArrayList);
            }
            localObject1 = aufd.a(((ek)localObject1).a().a, localFileManagerEntity.fileName);
            localObject2 = new atyk(this.a.jdField_a_of_type_AndroidContentContext, (atyn)localObject3);
            ((atyk)localObject2).a(11);
            ((atyk)localObject2).a((Rect)localObject1);
            ((atyk)localObject2).a();
          }
        }
      }
      else if (((DataLineMsgSet)localObject3).getGroupType() == -2000)
      {
        localObject1 = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, LiteMutiPicViewerActivity.class);
        ((Intent)localObject1).putExtra("dataline_group_id", ((DataLineMsgSet)localObject3).getGroupId());
        this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivity((Intent)localObject1);
      }
      else
      {
        localObject1 = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, DLFilesViewerActivity.class);
        ((Intent)localObject1).putExtra("dl_files_groupid", ((DataLineMsgSet)localObject3).getGroupId());
        this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult((Intent)localObject1, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dz
 * JD-Core Version:    0.7.0.1
 */