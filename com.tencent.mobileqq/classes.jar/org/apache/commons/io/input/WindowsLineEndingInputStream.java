package org.apache.commons.io.input;

import java.io.InputStream;

public class WindowsLineEndingInputStream
  extends InputStream
{
  private final boolean ensureLineFeedAtEndOfFile;
  private boolean eofSeen = false;
  private boolean injectSlashN = false;
  private boolean slashNSeen = false;
  private boolean slashRSeen = false;
  private final InputStream target;
  
  public WindowsLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.target = paramInputStream;
    this.ensureLineFeedAtEndOfFile = paramBoolean;
  }
  
  private int eofGame()
  {
    if (!this.ensureLineFeedAtEndOfFile) {
      return -1;
    }
    if ((!this.slashNSeen) && (!this.slashRSeen))
    {
      this.slashRSeen = true;
      return 13;
    }
    if (!this.slashNSeen)
    {
      this.slashRSeen = false;
      this.slashNSeen = true;
      return 10;
    }
    return -1;
  }
  
  private int readWithUpdate()
  {
    int i = this.target.read();
    boolean bool2 = true;
    boolean bool1;
    if (i == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.eofSeen = bool1;
    if (this.eofSeen) {
      return i;
    }
    if (i == 13) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.slashRSeen = bool1;
    if (i == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.slashNSeen = bool1;
    return i;
  }
  
  public void close()
  {
    super.close();
    this.target.close();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      throw new UnsupportedOperationException("Mark not supported");
    }
    finally {}
  }
  
  public int read()
  {
    if (this.eofSeen) {
      return eofGame();
    }
    if (this.injectSlashN)
    {
      this.injectSlashN = false;
      return 10;
    }
    boolean bool = this.slashRSeen;
    int i = readWithUpdate();
    if (this.eofSeen) {
      return eofGame();
    }
    if ((i == 10) && (!bool))
    {
      this.injectSlashN = true;
      return 13;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.WindowsLineEndingInputStream
 * JD-Core Version:    0.7.0.1
 */