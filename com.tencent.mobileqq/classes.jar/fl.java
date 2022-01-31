import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;

class fl
  implements View.OnClickListener
{
  fl(fk paramfk) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {}
    do
    {
      return;
      this.a.a();
      paramView = (fw)paramView.getTag();
      localObject2 = paramView.a();
      localObject1 = ((DataLineMsgSet)localObject2).getFirstItem();
      if (!((DataLineMsgSet)localObject2).isSingle()) {
        break;
      }
    } while (-1000 == ((DataLineMsgRecord)localObject1).msgtype);
    FileManagerEntity localFileManagerEntity = apug.a((DataLineMsgRecord)localObject1);
    if (bgtr.a().a(localFileManagerEntity))
    {
      bgtr.a().a(this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity.strFilePath, true);
      return;
    }
    if ((((DataLineMsgRecord)localObject1).nOpType == 31) || (apug.d(localFileManagerEntity)))
    {
      fk.a(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    if (((DataLineMsgRecord)localObject1).nOpType == 29)
    {
      fk.b(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    Object localObject2 = new apoj(this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity.nFileType == 0)
    {
      Iterator localIterator = fk.a(this.a).iterator();
      label335:
      while (localIterator.hasNext())
      {
        Object localObject3 = (DataLineMsgSet)localIterator.next();
        if (((DataLineMsgSet)localObject3).isSingle())
        {
          localObject3 = ((DataLineMsgSet)localObject3).values().iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label335;
            }
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
            int j = apug.a(localDataLineMsgRecord.filename);
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
            if (localDataLineMsgRecord != localObject1) {
              localArrayList.add(String.valueOf(apug.a(localDataLineMsgRecord).nSessionId));
            } else {
              localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
            }
          }
        }
      }
      if (localArrayList.size() == 0) {
        localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      }
      ((apoj)localObject2).a(localArrayList);
    }
    paramView = apvm.a(paramView.a().a, localFileManagerEntity.fileName);
    Object localObject1 = new apok(this.a.jdField_a_of_type_AndroidContentContext, (apon)localObject2);
    ((apok)localObject1).a(11);
    ((apok)localObject1).a(paramView);
    ((apok)localObject1).a();
    return;
    if (((DataLineMsgSet)localObject2).getGroupType() == -2000)
    {
      paramView = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, LiteMutiPicViewerActivity.class);
      paramView.putExtra("dataline_group_id", ((DataLineMsgSet)localObject2).getGroupId());
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, DLFilesViewerActivity.class);
    paramView.putExtra("dl_files_groupid", ((DataLineMsgSet)localObject2).getGroupId());
    this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fl
 * JD-Core Version:    0.7.0.1
 */